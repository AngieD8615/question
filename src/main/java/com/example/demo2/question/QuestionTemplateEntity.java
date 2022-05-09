package com.example.demo2.question;


import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@ToString
@Builder
@Setter
@Getter
@Entity
@Table(name = "question_templates")
@AllArgsConstructor
@NoArgsConstructor
public class QuestionTemplateEntity {
    @Id
    @GeneratedValue
    private UUID questionTemplateId;
    private String topic;
    private String baseQuestion;
    private String solutionEquation;
    private String solutionUnit;

    public QuestionTemplateEntity(String topic, String baseQuestion, String solutionEquation, String solutionUnit) {
        this.topic = topic;
        this.baseQuestion = baseQuestion;
        this.solutionEquation = solutionEquation;
        this.solutionUnit = solutionUnit;
    }



}
