package com.example.demo2.question;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@ToString
@Builder
@Setter
@Getter
@Entity
@Table(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {

    @Id
    @GeneratedValue
    private UUID questionId;

    private String baseQuestion;
    private String solutionEquation;
    private String solutionUnit;
//    private Object variables;

}
