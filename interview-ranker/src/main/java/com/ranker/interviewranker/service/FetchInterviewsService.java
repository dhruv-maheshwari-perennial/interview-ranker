package com.ranker.interviewranker.service;

import com.ranker.interviewranker.domain.request.interview.InterviewDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FetchInterviewsService {
    List<InterviewDetails> getAll();

    ResponseEntity<Object> getAllInterviews();
}
