package com.fs.quiz.periphery.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for Question Controller
 */

public class QuestionsControllerTest extends AbstractIntegrationTest {


    @Test
    public void getQuestionsShouldReturnQuestions() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/questions").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.questions", hasSize(5)))
                .andExpect(jsonPath("$.questions[0].id").value("188a8b5a-4ad7-4814-8d4d-9755a5a9969f"))
                .andExpect(jsonPath("$.questions[0].quizId").value("47b6dd82-78ab-408f-9b15-01e9d76316fe"))
                .andExpect(jsonPath("$.questions[0].question").value("What is the capital of US?"));

    }

    @Test
    public void getQuestionsByQuizTypeShouldReturnQuestionsForScienceType() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/questions/types/science").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.questions", hasSize(1)))
                .andExpect(jsonPath("$.questions[0].id").value("dcd5d9ea-7252-47bf-9843-1bf05d7ac3af"))
                .andExpect(jsonPath("$.questions[0].quizId").value("fcd5d9ea-7252-47bf-9843-1bf05d7ac3af"))
                .andExpect(jsonPath("$.questions[0].question").value("What is the formula of water?"));

    }

}
