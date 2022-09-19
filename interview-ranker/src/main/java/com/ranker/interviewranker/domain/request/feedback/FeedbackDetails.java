package com.ranker.interviewranker.domain.request.feedback;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ranker.interviewranker.domain.request.interview.InterviewDetails;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedbackDetails {
    private InterviewDetails interviewDetails;
    private Object feedbacks;
}
