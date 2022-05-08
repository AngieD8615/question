package com.example.demo2.question;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionController.class)
public class QuestionControllerTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    QuestionService questionService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void getAllQuestionsList() throws Exception {
        List<QuestionEntity> questions = new ArrayList<>();
        QuestionEntity questionA = new QuestionEntity();
        questionA.setTopic("1-D Motion");

        QuestionEntity questionB = new QuestionEntity();
        questionB.setTopic("Free Fall");

        questions.add(questionA);
        questions.add(questionB);

        when(questionService.getQuestionsList()).thenReturn(questions);

        mockMvc.perform(get("/questions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void postQuestion_valid_returnsQuestion() throws Exception {
        Map<String, Variable> variables = new HashMap<String, Variable>();
        variables.put("H", new Variable(2, 10, 3));

        QuestionEntity questionA = new QuestionEntity(
                "Free Fall",
                "A ball is dropped from a height of ${H}m. How long will it take to hit the ground?",
                "( %{H} / 4.9 ) ^ 0.5 )",
                "sec",
                variables
                );
        questionA.serializeVariables();

        when(questionService.postQuestion(any(QuestionEntity.class))).thenReturn(questionA);

        mockMvc.perform(post("/questions").contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(questionA)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.topic", hasToString(questionA.getTopic())))
                .andExpect(jsonPath("$.variablesJSON", hasToString(questionA.getVariablesJSON())));

    }
}
