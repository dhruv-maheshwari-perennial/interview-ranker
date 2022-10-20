package com.ranker.interviewranker.domain.dto;

import com.ranker.interviewranker.domain.model.track.InterviewTrackFields;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "interview-track")
public class InterviewTrackDTO {
    @Id
    private String trackId;
    private String interviewTrack;
    private List<InterviewTrackFields> interviewTrackFieldsList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
