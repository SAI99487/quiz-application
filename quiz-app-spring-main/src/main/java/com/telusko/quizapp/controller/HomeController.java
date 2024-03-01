package com.telusko.quizapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController 
{
	@GetMapping("home")
	public String index()
	{
		


		return "index.jsp";
	}
	@GetMapping("create")
	public String indexa()
	{
		


		return "createquiz.html";
	}
	@GetMapping("exam")
	public String indexb()
	{
		


		return "quizquestions.html";
	}
	/*
    public List<QuestionWrapper> getQuizQuestion(Long id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return questionsForUser;

	
    
    @GetMapping("geta")
    public String getQuizQuestion()
    {
    	return "hihelodsfd";
    }
    
    
    
    
    //@GetMapping("ge/{id}")
    //public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Long id,Model model){
    /*@GetMapping("ge/{id}")
    public String getQuizQuestion(@PathVariable Long id,Model model){
    	
    	
    	model.addAttribute("questions for user",questionsForUser);


        //return quizService.getQuizQuestions(id);
        //return "quiz.jsp";
        return "hi hello hi ";
    }
    public List<QuestionWrapper> getQuizQuestion(Long id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return questionsForUser;
        

    }*/



}
