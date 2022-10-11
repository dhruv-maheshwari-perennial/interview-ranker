package com.ranker.interviewranker.service;

import org.springframework.http.ResponseEntity;

public interface ConsumerService {
    ResponseEntity<Object> saveAllFetchInterviews();
}
