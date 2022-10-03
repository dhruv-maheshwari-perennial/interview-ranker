package com.ranker.interviewranker.service;

import com.ranker.interviewranker.domain.dto.InterviewTrackDTO;
import org.springframework.http.ResponseEntity;

public interface InterviewTrackService {
    ResponseEntity<Object> saveInterviewTrackField(InterviewTrackDTO interviewTrackDTO);
}
