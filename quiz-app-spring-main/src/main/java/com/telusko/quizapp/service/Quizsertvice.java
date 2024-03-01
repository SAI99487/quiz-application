package com.telusko.quizapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.telusko.quizapp.model.QuestionWrapper;

public interface Quizsertvice {
	ResponseEntity<List<QuestionWrapper>> getquizquestions(Long id);

}
