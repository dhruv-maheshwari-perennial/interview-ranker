package com.ranker.interviewranker.domain.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class InterviewTrackFields {
    private String labelName;
    private String columnName;
    private String dataType;
}
