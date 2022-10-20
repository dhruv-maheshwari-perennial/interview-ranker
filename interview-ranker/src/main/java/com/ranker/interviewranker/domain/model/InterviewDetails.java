package com.ranker.interviewranker.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
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

   public void setDateAndTime(LocalDateTime dateAndTime) {
      this.dateAndTime = dateAndTime;
   }

   public void setCandidateName(String candidateName) {
      this.candidateName = candidateName.toLowerCase();
   }

   public void setRecruiterName(String recruiterName) {
      this.recruiterName = recruiterName.toLowerCase();
   }

   public void setInterviewTrack(String interviewTrack) {
      this.interviewTrack = interviewTrack.toLowerCase();
   }

   public void setPanelName(String panelName) {
      this.panelName = panelName.toLowerCase();
   }
}