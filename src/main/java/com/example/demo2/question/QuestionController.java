package com.example.demo2.question;

import lombok.AllArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuestionController {

    @GetMapping("/questions")
    public String getQuestions() {
        return "hello from get questions";
    }

    @PostMapping("/questions")
    public String postQuestion() {
        return "hello from post questions";
    }
}
