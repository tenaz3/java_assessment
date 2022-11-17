package com.fs.quiz.core.service;

import com.fs.quiz.core.domainobject.Answer;
import com.fs.quiz.core.repository.AnswerRepository;
import com.fs.quiz.periphery.boundary.request.AnswerCheckRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository repository;

    public boolean check(AnswerCheckRequest request) {
        Answer answer = repository.findByQuizIdAndQuestionIdAndIsCorrectTrue(UUID.fromString(request.getQuizId()), UUID.fromString(request.getQuestionId()))
                .orElseThrow(EntityNotFoundException::new);
        return answer.getAnswer().equalsIgnoreCase(request.getAnswer());
    }
}
