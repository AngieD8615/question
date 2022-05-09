package com.example.demo2.question;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final FinalQuestionRepository questionVariantRepository;

    public List<QuestionTemplateEntity> getQuestionTemplatesList() {
        return questionRepository.findAll();
    }

    public QuestionTemplateEntity postQuestionTemplate(QuestionTemplateEntity question) {
        return questionRepository.save(question);
    }

    public void deleteAllQuestionTemplates() {
        questionRepository.deleteAll();
    }
}
