package com.akindu.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.akindu.quizapp.dao.QuestionDao;
import com.akindu.quizapp.dao.QuizDao;
import com.akindu.quizapp.model.Question;
import com.akindu.quizapp.model.Quiz;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandonQuestionByCategory(category, numQ); 

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<String>("Success", HttpStatus.CREATED);
    }
}
