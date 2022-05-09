package com.example.demo2.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
    private String topic;
    private String baseQuestion;
    private String solutionEquation;
    private String solutionUnit;
    private String variablesJSON;
    @Transient
    private Map<String, Variable> variables = new HashMap<String, Variable>();

    public QuestionEntity(String topic, String baseQuestion, String solutionEquation, String solutionUnit, Map<String, Variable> variables) {
        this.topic = topic;
        this.baseQuestion = baseQuestion;
        this.solutionEquation = solutionEquation;
        this.solutionUnit = solutionUnit;
        this.variables = variables;
    }

    public void serializeVariables() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        this.variablesJSON = mapper.writeValueAsString(variables);
    }

}
