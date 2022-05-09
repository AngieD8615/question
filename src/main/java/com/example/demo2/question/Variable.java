package com.example.demo2.question;


import lombok.*;

import java.util.List;

@ToString
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Variable {
    private Double min;
    private Double max;
    private Double interval;
}
