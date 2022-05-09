package com.example.demo2.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @InjectMocks
    QuestionService questionService;

    @Mock
    QuestionRepository questionRepository;
    @Mock
    QuestionVariantRepository questionVariantRepository;

    @BeforeEach
    void setUp() {
        questionService = new QuestionService(questionRepository, questionVariantRepository);
    }

    @Test
    void listQuestions() {
        List<QuestionEntity> allQuestions = questionService.getQuestionsList();

        assertThat(allQuestions).isNotNull();
    }

    //TODO
    @Test
    void postQuestion() {
    }

    //TODO
    @Test
    void deleteAllQuestions() {
    }
}