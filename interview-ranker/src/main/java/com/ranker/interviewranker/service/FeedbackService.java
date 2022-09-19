package com.ranker.interviewranker.service;

import org.springframework.http.ResponseEntity;

public interface FeedbackService {
    ResponseEntity<Object> addFeedback(String candidateName, Object feedback);
}
