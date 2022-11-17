package com.fs.quiz.core.domainobject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "quiz_type")
@NoArgsConstructor
@Getter
public class QuizType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "type_name", nullable = false, unique = true)
    private String typeName;
}
