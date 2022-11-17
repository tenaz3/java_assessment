package com.fs.quiz.core.service;

import com.fs.quiz.core.domainobject.Quiz;
import com.fs.quiz.core.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository repository;

    public Quiz getQuiz(String id) {
        return repository.findById(UUID.fromString(id)).orElseThrow(EntityNotFoundException::new);
    }
}
