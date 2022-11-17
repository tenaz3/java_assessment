package com.fs.quiz.periphery.controller;

import com.fs.quiz.core.domainobject.Question;
import com.fs.quiz.core.service.QuizService;
import com.fs.quiz.periphery.boundary.response.QuestionResponse;
import com.fs.quiz.periphery.boundary.response.QuizResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizzesController {
    private final QuizService service;

    @GetMapping("/{id}")
    public QuizResponse getQuiz(@PathVariable String id) {
        final var quiz = service.getQuiz(id);
        return QuizResponse.builder()
                .id(quiz.getId().toString())
                .title(quiz.getTitle())
                .quizType(quiz.getQuizType().getTypeName())
                .questions(mapQuestions(quiz.getQuestions()))
                .build();
    }

    private static List<QuestionResponse> mapQuestions(List<Question> questions) {
        return questions.stream().map(question -> QuestionResponse.builder()
                .id(question.getId().toString())
                .quizId(question.getQuizId().toString())
                .question(question.getQuestion()).build()).collect(Collectors.toList());
    }
}
