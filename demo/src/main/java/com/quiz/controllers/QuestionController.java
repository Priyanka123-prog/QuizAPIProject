package com.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.Question;
import com.quiz.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	//without handling exception
	
	/*@GetMapping("allQuestions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public List<Question> getQuestionsByCategory( @PathVariable String category) {
		return questionService.getQuestionsByCategory(category);
		
	}
	
	@PostMapping("add")
	public String addQuestion (@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	//try to make update and delete data
	
	@PutMapping("update/{id}")
	public String updateQuestion (@RequestBody Question question,@PathVariable int id) {
		return questionService.updateQuestion(question,id);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteQuestion (@PathVariable int id) {
		return questionService.deleteQuestion(id);
		  
	}*/
	
	
	//with handling exception
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory( @PathVariable String category) {
		return questionService.getQuestionsByCategory(category);
		
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion (@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
}
