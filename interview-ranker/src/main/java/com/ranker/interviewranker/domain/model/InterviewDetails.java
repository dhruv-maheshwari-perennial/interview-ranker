package com.ranker.interviewranker.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.jetbrains.annotations.NotNull;
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

   public void setCandidateName(@NotNull String candidateName) {
      this.candidateName = candidateName.toLowerCase();
   }

   public void setRecruiterName(@NotNull String recruiterName) {
      this.recruiterName = recruiterName.toLowerCase();
   }

   public void setInterviewTrack(@NotNull String interviewTrack) {
      this.interviewTrack = interviewTrack.toLowerCase();
   }

   public void setPanelName(@NotNull String panelName) {
      this.panelName = panelName.toLowerCase();
   }
}