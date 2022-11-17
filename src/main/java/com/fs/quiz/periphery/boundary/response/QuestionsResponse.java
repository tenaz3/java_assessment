package com.fs.quiz.periphery.boundary.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionsResponse {
    private List<QuestionResponse> questions;
}
