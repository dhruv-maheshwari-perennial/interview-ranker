package com.ranker.interviewranker.domain.model;

import java.util.List;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Interviews {
   private List<InterviewDetails> interviews;
}