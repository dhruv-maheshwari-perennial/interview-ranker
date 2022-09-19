package com.ranker.interviewranker.domain.request.feedback;

import lombok.*;

import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Feedbacks {
    List<FeedbackDetails> feedbacks;
}
