package com.example.demo2.question;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class QuestionEntityToVariantEntityTest {
    QuestionEntityToVariantEntity questionEntityToVariantEntity = new QuestionEntityToVariantEntity();

    @Test
    void replaceAllVariablesWithValues() {
        String equation = "H / H * 9.8 * (( H / 4.9 ) ** 0.5) - d";
        List<variableValues> values = new ArrayList<>();
        values.add(new variableValues("H", 10.0));
        values.add(new variableValues("d", 3.0));

        assertThat(questionEntityToVariantEntity.replaceVariablesWithValues(equation, values))
                .isEqualTo("10.0 / 10.0 * 9.8 * (( 10.0 / 4.9 ) ** 0.5) - 3.0");

    }

    @Test
    void calculateResultTest() throws ScriptException {
        String equation = "9.8 * (( H / 4.9 ) ** 0.5) - d";
        List<variableValues> values = new ArrayList<>();
        values.add(new variableValues("H", 10.0));
        values.add(new variableValues("d", 3.0));

        Double expected = 9.8 * (Math.pow(10/4.9, 0.5));

        assertThat((Double)questionEntityToVariantEntity.calculateResult(equation,values)).isCloseTo(expected, offset(.0001));
    }
}