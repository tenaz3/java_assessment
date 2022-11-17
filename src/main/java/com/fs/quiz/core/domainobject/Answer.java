package com.fs.quiz.core.domainobject;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "answer")
@NoArgsConstructor
@Getter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "quiz_id", nullable = false)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID quizId;

    @Column(name = "question_id", nullable = false)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID questionId;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @Column(name = "answer")
    private String answer;


}
