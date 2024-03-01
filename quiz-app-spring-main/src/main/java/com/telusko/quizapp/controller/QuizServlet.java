package com.telusko.quizapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.telusko.quizapp.model.QuestionWrapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/quiz/get/*")
public class QuizServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract the path information
        String pathInfo = request.getPathInfo();
        
        // Get the quiz number from the path
        String quizNumber = pathInfo.substring(1); // remove the leading '/'
        
        // Retrieve questions based on the quiz number
        List<QuestionWrapper> questions = retrieveQuestions(Integer.parseInt(quizNumber)); // Implement this method
        
        // Set the questions as an attribute in the request
        request.setAttribute("questions", questions);
        
        // Forward the request to the Quiz.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Quiz.jsp");
        dispatcher.forward(request, response);
    }
    
    // Implement this method to retrieve questions from your data source
    private List<QuestionWrapper> retrieveQuestions(int quizNumber) {
        // Implement your logic to fetch questions based on the quiz number
        // Replace this with your actual data retrieval mechanism
        // For simplicity, return a dummy list
        List<QuestionWrapper> questions = new ArrayList<>();
        questions.add(new QuestionWrapper("Question 1", Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4"), "Category"));
        questions.add(new QuestionWrapper("Question 2", Arrays.asList("Option X", "Option Y", "Option Z", "Option W"), "Category 2"));
        return questions;
    }
}