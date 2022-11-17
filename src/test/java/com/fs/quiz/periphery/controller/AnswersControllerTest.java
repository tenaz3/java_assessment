package com.fs.quiz.periphery.controller;

import com.fs.quiz.periphery.boundary.request.AnswerCheckRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AnswersControllerTest extends AbstractIntegrationTest {

    @Test
    public void checkShouldReturnAnswer() throws Exception {
        final var request = AnswerCheckRequest.builder()
                .quizId("47b6dd82-78ab-408f-9b15-01e9d76316fe")
                .questionId("37b6dc82-78ab-408f-9b15-01e9d76316fe")
                .answer("berlin")
                .build();

        mvc.perform(MockMvcRequestBuilders.post("/api/answers")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.quizId").value(request.getQuizId()))
                .andExpect(jsonPath("$.questionId").value(request.getQuestionId()))
                .andExpect(jsonPath("$.correct").value(true))
                .andExpect(jsonPath("$.answer").value(request.getAnswer()));

    }

    @Test
    public void checkShouldReturn404() throws Exception {
        final var request = AnswerCheckRequest.builder()
                .quizId("47c15933-662f-49ae-b675-e0a610e11bec")
                .questionId("46c15933-962f-49ae-b675-e0a610e12bec")
                .answer("berlin")
                .build();

        mvc.perform(MockMvcRequestBuilders.post("/api/answers")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Can not find the data"));

    }

}