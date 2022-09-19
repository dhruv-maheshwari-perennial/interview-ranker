package com.ranker.interviewranker.domain.request.interview;

import java.util.List;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Interviews {
   private List<InterviewDetails> interviews;
}