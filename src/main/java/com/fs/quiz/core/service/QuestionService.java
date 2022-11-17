package com.fs.quiz.core.service;

import com.fs.quiz.core.domainobject.Question;
import com.fs.quiz.core.repository.QuestionRepository;
import com.fs.quiz.periphery.boundary.request.QuestionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Question Service implementation
 */
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository repository;

    public List<Question> getQuestions() {
        return repository.findAll();
    }

    public Question create(QuestionRequest request) {
        return repository.save(new Question(UUID.fromString(request.getQuizId()), request.getQuestion()));
    }

    public List<Question> getQuestionsByQuizType(String type) {
        return repository.findQuestionsByQuizType(type);
    }
}
