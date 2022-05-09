package com.example.demo2.question;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ToString
@Builder
@Setter
@Getter
@Entity
@Table(name = "question_variants")
@AllArgsConstructor
@NoArgsConstructor
public class QuestionVariantEntity {

    @Id
    @GeneratedValue
    private UUID questionVariantId;
    private UUID questionTemplateId;
    private String variableName;
    private Double variableValue;
}
