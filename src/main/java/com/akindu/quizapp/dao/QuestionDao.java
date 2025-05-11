package com.akindu.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akindu.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    // JpaRepository provides built-in methods for CRUD operations
    // You can define custom query methods here if needed

    List<Question> findByCategory (String category);

    @Query(
        value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ",
        nativeQuery = true
    )
    List<Question> findRandonQuestionByCategory(String category, int numQ);

    
    
}
