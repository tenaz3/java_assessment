package com.fs.quiz.periphery.boundary.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerCheckRequest {
    private String quizId;
    private String questionId;
    private String answer;
}
