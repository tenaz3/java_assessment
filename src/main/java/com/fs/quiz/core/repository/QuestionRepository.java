package com.fs.quiz.core.repository;

import com.fs.quiz.core.domainobject.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Static Question Repository implementation
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {

    @Query(value = "SELECT qu" +
            " FROM Question qu " +
            " INNER JOIN QuizType t ON t.typeName = :type " +
            " INNER JOIN Quiz q ON q.quizType.id = t.id " +
            " WHERE qu.quizId = q.id")
    List<Question> findQuestionsByQuizType(@Param("type") String type);
}