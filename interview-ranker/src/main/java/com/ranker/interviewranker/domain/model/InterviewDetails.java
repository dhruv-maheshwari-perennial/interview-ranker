package com.ranker.interviewranker.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "interviews")
public class InterviewDetails {
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private LocalDateTime dateAndTime;
   private String candidateName;
   private String recruiterName;
   private String interviewTrack;
   private String panelName;
}