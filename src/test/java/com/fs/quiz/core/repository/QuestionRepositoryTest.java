package com.fs.quiz.core.repository;

import com.fs.quiz.core.domainobject.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository repository;


    @Test
    void findQuestionsByQuizTypeGeographyShouldReturnList() {
        List<Question> questions = repository.findQuestionsByQuizType("geography");

        assertThat(questions).hasSize(4);
    }

    @Test
    public void findQuestionsByQuizTypeMediaShouldReturnEmpty() {
        List<Question> questions = repository.findQuestionsByQuizType("media");

        assertThat(questions).isEmpty();
    }
}