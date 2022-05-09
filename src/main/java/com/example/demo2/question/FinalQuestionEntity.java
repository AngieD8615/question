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
@Table(name = "final_questions")
@AllArgsConstructor
@NoArgsConstructor
public class FinalQuestionEntity {
    @Id
    @GeneratedValue
    private UUID finalQuestionId;
    private UUID questionTemplateId;
    private String finalQuestion;
    private Double result;
}
