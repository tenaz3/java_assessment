package com.fs.quiz.core.repository;

import com.fs.quiz.core.domainobject.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, UUID> {
    Optional<Answer> findByQuizIdAndQuestionIdAndIsCorrectTrue(UUID quizId, UUID questionId);
}