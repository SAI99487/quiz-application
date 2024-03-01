package com.telusko.quizapp.controller;

import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.dao.QuizDao;
import com.telusko.quizapp.model.Question;

import com.telusko.quizapp.model.QuestionWrapper;
import com.telusko.quizapp.model.Quiz;
import com.telusko.quizapp.model.Response;
import com.telusko.quizapp.service.QuizService;
import com.telusko.quizapp.service.Quizsertvice;

//import ch.qos.logback.core.model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
// controller for quiz
@Controller
@RequestMapping("quiz")
public class QuizController {

	
    @Autowired
    QuizService quizService;
    @Autowired
    Quizsertvice quizservice;

    
    @Autowired
    QuizDao quizDao;
    @Autowired  
    QuestionDao questionDao;
    List<QuestionWrapper> questionsForUser;
   // questionsForUser questionforuser;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        
    	//return new ResponseEntity<>("i am hree",HttpStatus.OK);
    	return quizService.createQuiz(category, numQ, title);
    }
    
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Long id){


        return quizService.getQuizQuestions(id);
    }
 /*   @GetMapping("/questions/{id}")
    public String showQuizQuestions(@PathVariable Long id, Model model) {
        model.addAttribute("quizId", id);
        return "quizquestions.html"; // Ensure the case matches and the path is correct
    }*/

    @GetMapping("question/{id}")
    public String getQuizQuestions(@PathVariable Long id, Model model){
        List<QuestionWrapper> questions = quizService.getQuizQuestions(id).getBody();
        model.addAttribute("questions", questions);
        return "quiz";  // Assuming "quiz.jsp" is in /WEB-INF/views/
    }
    /*
    @GetMapping("/quiz/{id}")
    public String getQuizQuestions(@PathVariable Long id, Model model) {
        ResponseEntity<List<QuestionWrapper>> response = quizservice.getquizquestions(id);

        if (response.getStatusCode() == HttpStatus.OK) {
            model.addAttribute("questionForUser", response.getBody());
            return "quiz.jsp";
        } else {
            // Handle error, maybe redirect to an error page
            return "error";
        }
    }
*/
    @PostMapping("/submitAnswer")
    public String submitAnswer(@RequestParam Long questionId, @RequestParam String answer) {
        // Handle answer submission logic here
        // You may want to compare the answer with the correct one, update the score, etc.
        return "redirect:/quiz/{id}"; // Redirect back to the quiz page
    }

    
    
    
    
    
    
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }


}
