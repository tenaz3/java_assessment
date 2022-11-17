package com.fs.quiz.core.service;

import com.fs.quiz.core.domainobject.Quiz;
import com.fs.quiz.core.repository.QuizRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {

    @Mock
    private QuizRepository repository;

    @InjectMocks
    private QuizService service;

    @Test
    public void getQuizByIdShouldReturnQuiz() {
        // GIVEN
        final var id = UUID.randomUUID();
        final var quiz = new Quiz();
        when(repository.findById(id)).thenReturn(Optional.of(quiz));

        // WHEN
        Quiz actualQuiz = service.getQuiz(id.toString());


        // THEN
        assertThat(actualQuiz).isNotNull();

        verify(repository, times(1)).findById(id);
    }

    @Test
    public void getQuizByIdShouldThrowEntityNotFoundException() {
        // GIVEN
        final var id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());

        // WHEN
        // THEN
        assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(() -> service.getQuiz(id.toString()));

        verify(repository, times(1)).findById(id);
    }
}
