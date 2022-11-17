package com.fs.quiz.periphery.boundary.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionResponse {
    private String id;
    private String quizId;
    private String question;
}
