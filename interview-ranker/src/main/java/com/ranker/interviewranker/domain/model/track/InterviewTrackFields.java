package com.ranker.interviewranker.domain.model.track;

import lombok.*;

import java.util.ArrayList;

@Getter
@ToString
@NoArgsConstructor
public class InterviewTrackFields {
    private String labelName;
    private String columnName;
    private String dataType;
    private FieldValidations validation;
    private boolean optional;

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setValidation(FieldValidations validation) {
        if (validation.getOptions() == null) {
            validation.setOptions(new ArrayList<>());
        }

        this.validation = validation;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }
}
