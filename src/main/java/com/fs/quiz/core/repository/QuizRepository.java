package com.fs.quiz.core.repository;

import com.fs.quiz.core.domainobject.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuizRepository extends JpaRepository<Quiz, UUID> {
}
