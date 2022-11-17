package com.fs.quiz.core.service;

import com.fs.quiz.core.domainobject.Answer;
import com.fs.quiz.core.repository.AnswerRepository;
import com.fs.quiz.periphery.boundary.request.AnswerCheckRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnswerServiceTest {
    @Mock
    private AnswerRepository repository;

    @InjectMocks
    private AnswerService service;

    @Test
    public void checkShouldReturnTrueForCorrectAnswer() {
        // GIVEN
        final var request = AnswerCheckRequest.builder()
                .quizId(UUID.randomUUID().toString())
                .questionId(UUID.randomUUID().toString())
                .answer("Brasilia")
                .build();
        final var expectedAnswer = Mockito.mock(Answer.class);
        when(expectedAnswer.getAnswer()).thenReturn("brasilia");
        when(repository.findByQuizIdAndQuestionIdAndIsCorrectTrue(UUID.fromString(request.getQuizId()), UUID.fromString(request.getQuestionId())))
                .thenReturn(Optional.of(expectedAnswer));

        // WHEN
        final var actualAnswer = service.check(request);

        // THEN
        assertThat(actualAnswer).isTrue();
        verify(repository, times(1)).findByQuizIdAndQuestionIdAndIsCorrectTrue(UUID.fromString(request.getQuizId()), UUID.fromString(request.getQuestionId()));

    }


    @Test
    public void checkShouldThrowEntityNotFoundException() {
        // GIVEN
        final var request = AnswerCheckRequest.builder()
                .quizId(UUID.randomUUID().toString())
                .questionId(UUID.randomUUID().toString())
                .answer("Brasilia")
                .build();
        when(repository.findByQuizIdAndQuestionIdAndIsCorrectTrue(any(), any())).thenReturn(Optional.empty());

        // WHEN
        // THEN
        assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(() -> service.check(request));
        verify(repository, times(1)).findByQuizIdAndQuestionIdAndIsCorrectTrue(UUID.fromString(request.getQuizId()), UUID.fromString(request.getQuestionId()));
    }

}