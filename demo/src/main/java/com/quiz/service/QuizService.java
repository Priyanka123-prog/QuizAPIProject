package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.entity.Question;
import com.quiz.entity.Quiz;
import com.quiz.repository.QuestionRepo;
import com.quiz.repository.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	private QuestionRepo questionRepo;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		
		List<Question> questions=questionRepo.findRandomQuestionByCategory(numQ,category);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		return null;
	} 

}
