package com.ranker.interviewranker.domain.model.track;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FieldValidations {
    private List<String> options;
    private int min;
    private int max;
}
