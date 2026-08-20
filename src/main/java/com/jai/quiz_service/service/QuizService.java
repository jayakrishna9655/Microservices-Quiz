package com.jai.quiz_service.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jai.quiz_service.controller.quizInterface;
import com.jai.quiz_service.dao.QuizDao;
import com.jai.quiz_service.model.QuestionWrapper;
import com.jai.quiz_service.model.Quiz;
import com.jai.quiz_service.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    
    @Autowired
    quizInterface quizinterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizinterface.getQuestionsForQuiz(category, numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    @Transactional
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionId = new ArrayList<>(quiz.getQuestionIds());
        ResponseEntity<List<QuestionWrapper>> questions = quizinterface.getQuestionsFromId(questionId);
        return questions;

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

    	ResponseEntity<Integer> score = quizinterface.getScore(responses);
    	
        return score;
    }
}
