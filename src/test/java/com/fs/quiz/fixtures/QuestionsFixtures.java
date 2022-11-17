package com.fs.quiz.fixtures;

import com.fs.quiz.core.domainobject.Question;

import java.util.List;
import java.util.UUID;

public class QuestionsFixtures {

    public static List<Question> questionsByQuizGeographyType() {
        return List.of(new Question(UUID.randomUUID(),"What is the biggest country in the world?"));
    }
}
