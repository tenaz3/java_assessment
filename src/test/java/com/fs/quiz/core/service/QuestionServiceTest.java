package com.fs.quiz.core.service;

import com.fs.quiz.core.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static com.fs.quiz.fixtures.QuestionsFixtures.questionsByQuizGeographyType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Tests for Question Service
 */
@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private QuestionService service;

    @Test
    public void getQuestionsShouldReturnAllQuestions() {
        // GIVEN
        when(repository.findAll()).thenReturn(Collections.emptyList());

        // WHEN
        final var questions = service.getQuestions();

        // THEN
        assertThat(questions).isEmpty();
    }

    @Test
    public void getQuestionsByQuizTypeGeographyShouldReturn() {
        // GIVEN
        final var type = "geography";
        when(repository.findQuestionsByQuizType(type)).thenReturn(questionsByQuizGeographyType());

        // WHEN
        final var questions = service.getQuestionsByQuizType(type);

        // THEN
        assertThat(questions).isNotEmpty();
    }
}
