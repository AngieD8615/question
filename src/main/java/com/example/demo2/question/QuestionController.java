package com.example.demo2.question;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions")
    public List<QuestionEntity> getQuestions() {
        return questionService.getQuestionsList();
    }

    @PostMapping("/questions")
    @ResponseBody
    public QuestionEntity postQuestion(@RequestBody QuestionEntity question) throws JsonProcessingException {
        question.serializeVariables();

        return questionService.postQuestion(question);
    }

    @DeleteMapping("/questions")
    public void deleteAllQuestions() { questionService.deleteAllQuestions();}
}
