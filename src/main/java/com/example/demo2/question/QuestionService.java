package com.example.demo2.question;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionVariantRepository questionVariantRepository;

    public List<QuestionEntity> getQuestionsList() {
        return questionRepository.findAll();
    }

    // TODO
    public QuestionEntity postQuestion(QuestionEntity question) {
        QuestionEntity questionData = questionRepository.save(question);
        UUID questionId = questionData.getQuestionId();
        String equation = questionData.getSolutionEquation();

        for (Map.Entry<String, Variable> variable : questionData.getVariables().entrySet()) {


        }
        return questionData;
    }

    public void deleteAllQuestions() {
        questionRepository.deleteAll();
    }
}
