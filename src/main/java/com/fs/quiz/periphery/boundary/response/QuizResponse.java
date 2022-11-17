package com.fs.quiz.periphery.boundary.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuizResponse {
    private String id;
    private String quizType;
    private String title;
    private List<QuestionResponse> questions;
}
