package com.akindu.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.akindu.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {


    
} 