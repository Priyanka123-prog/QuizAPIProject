package com.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.entity.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer>{
	
	List<Question> findByCategory(String category);

	@Query(value="select * from Question q where q.category=:category order by random() limit=:numQ")
	List<Question> findRandomQuestionByCategory(int numQ, String category);

}
