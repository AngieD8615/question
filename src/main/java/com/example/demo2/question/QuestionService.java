package com.example.demo2.question;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<QuestionEntity> getQuestionsList() {
        return questionRepository.findAll();
    }

    public QuestionEntity postQuestion(QuestionEntity question) {
        return questionRepository.save(question);
    }

    public void deleteAllQuestions() {
        questionRepository.deleteAll();
    }
}
