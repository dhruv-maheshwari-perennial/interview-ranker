package com.ranker.interviewranker.service;

import com.ranker.interviewranker.domain.request.interview.InterviewDetails;
import org.springframework.http.ResponseEntity;

public interface ConsumerService {
    ResponseEntity<Object> getAllInterviews();
}
