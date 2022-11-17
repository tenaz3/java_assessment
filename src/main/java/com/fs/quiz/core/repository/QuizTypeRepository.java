package com.fs.quiz.core.repository;

import com.fs.quiz.core.domainobject.QuizType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface
QuizTypeRepository extends JpaRepository<QuizType, UUID> {
}
