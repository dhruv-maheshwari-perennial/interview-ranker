package com.ranker.interviewranker.service;

import com.ranker.interviewranker.domain.model.InterviewDetails;
import org.springframework.http.ResponseEntity;

public interface ConsumerService {
    ResponseEntity<Object> saveAllFetchInterviews();

    ResponseEntity<Object> saveInterview(InterviewDetails interviewDetails);

    ResponseEntity<Object> viewAllSavedInterviews();

    ResponseEntity<Object> updateInterview(String candidateName, String interviewTrack, InterviewDetails updatedInterviewDetails);

//    ResponseEntity<Object> deleteInterview(String candidateName, String interviewTrack);
}
