package com.fs.quiz.periphery.boundary.request;

import lombok.Data;

@Data
public class QuestionRequest {
    private String quizId;
    private String question;
}
