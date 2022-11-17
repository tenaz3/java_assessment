package com.fs.quiz.periphery.controller;

import com.fs.quiz.core.domainobject.Question;
import com.fs.quiz.core.service.QuestionService;
import com.fs.quiz.periphery.boundary.request.QuestionRequest;
import com.fs.quiz.periphery.boundary.response.QuestionResponse;
import com.fs.quiz.periphery.boundary.response.QuestionsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * Question Controller class
 */
@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionService service;

    @GetMapping
    public QuestionsResponse getQuestions() {
        final var questions = service.getQuestions()
                .stream().map(QuestionsController::mapper)
                .collect(Collectors.toList());
        return QuestionsResponse.builder().questions(questions).build();
    }

    @PostMapping
    public QuestionResponse create(@RequestBody QuestionRequest request) {
        final var question = service.create(request);
        return mapper(question);
    }

    @GetMapping("/types/{type}")
    public QuestionsResponse getQuestionsByQuizType(@PathVariable String type) {
        final var questions = service.getQuestionsByQuizType(type.toLowerCase())
                .stream().map(QuestionsController::mapper)
                .collect(Collectors.toList());
        return QuestionsResponse.builder().questions(questions).build();

    }

    private static QuestionResponse mapper(Question question) {
        return QuestionResponse.builder()
                .id(question.getId().toString())
                .quizId(question.getQuizId().toString())
                .question(question.getQuestion())
                .build();
    }
}
