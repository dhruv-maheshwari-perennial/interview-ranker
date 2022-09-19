package com.ranker.interviewranker.domain.request.interview;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterviewDetails {
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private LocalDateTime dateAndTime;
   private String candidateName;
   private String recruiterName;
   private String interviewTrack;
   private String panelName;
}