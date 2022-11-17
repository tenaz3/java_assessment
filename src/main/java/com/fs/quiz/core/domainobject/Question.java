package com.fs.quiz.core.domainobject;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "question")
@NoArgsConstructor
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(name = "quiz_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID quizId;

    @Column(name = "question")
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", insertable = false, updatable = false)
    private Quiz quiz;

    public Question(UUID quizId, String question) {
        this.quizId = quizId;
        this.question = question;
    }
}
