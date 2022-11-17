package com.fs.quiz.periphery.boundary.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerResponse {
    private String quizId;
    private String questionId;
    private boolean isCorrect;
    private String answer;
}
