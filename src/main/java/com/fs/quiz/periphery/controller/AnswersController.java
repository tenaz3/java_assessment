package com.fs.quiz.periphery.controller;

import com.fs.quiz.core.service.AnswerService;
import com.fs.quiz.periphery.boundary.request.AnswerCheckRequest;
import com.fs.quiz.periphery.boundary.response.AnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswersController {
    private final AnswerService service;

    @PostMapping
    public AnswerResponse check(@RequestBody AnswerCheckRequest request) {
        final var answer = service.check(request);
        return AnswerResponse.builder()
                .quizId(request.getQuizId())
                .questionId(request.getQuestionId())
                .isCorrect(answer)
                .answer(request.getAnswer())
                .build();
    }
}
