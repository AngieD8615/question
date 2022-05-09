package com.example.demo2.question;

import lombok.Getter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class QuestionEntityToVariantEntity {

    private List<variableValues> values = new ArrayList<>();

    public String replaceVariablesWithValues(String equation, List<variableValues> values) {
        final String[] newString = new String[1];
        newString[0] = equation;
        values.forEach(value -> {
            newString[0] = newString[0].replaceAll(value.getVariable(), String.valueOf(value.getValue()));
        });
        return newString[0];
    }
    public Double calculateResult(String equation, List<variableValues> values){
        String equationWithoutVariables = replaceVariablesWithValues(equation, values);
        return 0.00;
    }

}

@Getter
class variableValues {
    private String variable;
    private Double value;

    public variableValues(String variable, Double value) {
        this.variable = variable;
        this.value = value;
    }
}
