package com.example.demo2.question;


import lombok.*;

import java.util.List;

@ToString
@Builder
@Setter
@Getter
@NoArgsConstructor
public class Variable {
    private int min;
    private int max;
    private int interval;

    public Variable(int min, int max, int interval) {
        this.min = min;
        this.max = max;
        this.interval = interval;
    }
}
