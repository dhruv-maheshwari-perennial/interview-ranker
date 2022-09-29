package com.ranker.interviewranker.domain.dto;

import com.ranker.interviewranker.enums.InterviewTrackEnum;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class InterviewTrackDTO {
    private InterviewTrackEnum interviewTrack;
    private List<InterviewTrackFields> interviewTrackFieldsList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
