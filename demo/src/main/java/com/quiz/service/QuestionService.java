package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.entity.Question;
import com.quiz.repository.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	//without handling exception
	/*public List<Question> getAllQuestions(){
		
		return questionRepo.findAll();
		
	}
	
    public List<Question> getQuestionsByCategory(String category){
		
		return questionRepo.findByCategory(category);
		
	}
    
    public String addQuestion(Question question) {
    	questionRepo.save(question);
    	return "success";
    }

	public String updateQuestion(Question question, int id) {
		Question que =questionRepo.findById(id).orElse(null);
		questionRepo.save(que);
		return "updated successfully";  
    	
	}

	public String  deleteQuestion(int id) {
		
		 questionRepo.deleteById(id);
		 return "deleted successfully";
	}*/
	
	//with handling exception
	
    public ResponseEntity<List<Question>> getAllQuestions(){
		try {
		return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}
    
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
    	try {
    		return new ResponseEntity<>(questionRepo.findByCategory(category),HttpStatus.OK);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
		
	}
    
    public ResponseEntity<String> addQuestion(Question question) {
    	try {
    	questionRepo.save(question);
    	return new ResponseEntity<>("success",HttpStatus.CREATED);
    	}
    	catch(Exception e) {
			e.printStackTrace();
		}
    	return new ResponseEntity<>("can not added data",HttpStatus.BAD_REQUEST);
    }
    

}
