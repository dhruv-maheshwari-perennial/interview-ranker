package com.ranker.interviewranker.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranker.interviewranker.domain.request.feedback.FeedbackDetails;
import com.ranker.interviewranker.domain.request.interview.InterviewDetails;
import com.ranker.interviewranker.domain.request.interviewTracks.FrontendTrack;
import com.ranker.interviewranker.domain.request.interviewTracks.JavaTrack;
import com.ranker.interviewranker.domain.response.ResponseHandler;
import com.ranker.interviewranker.service.FeedbackService;
import com.ranker.interviewranker.service.FetchInterviewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FetchInterviewsService fetchInterviewsService;

    @Override
    public ResponseEntity<Object> addFeedback(String candidateName, Object feedback) {
        ObjectMapper objectMapper = new ObjectMapper();
        FeedbackDetails feedbackDetails = new FeedbackDetails();
        InterviewDetails candidateDetails = fetchInterviewsService.getAll()
                .stream()
                .filter(id -> id.getCandidateName()
                        .trim()
                        .equalsIgnoreCase(candidateName.trim()))
                .toList()
                .get(0);

        feedbackDetails.setInterviewDetails(candidateDetails);

        switch (candidateDetails.getInterviewTrack().toLowerCase()) {
            case "java":
                JavaTrack javaTrack =  objectMapper.convertValue(feedback, JavaTrack.class);
                feedbackDetails.setFeedbacks(javaTrack);
                break;

            case "front-end":
                FrontendTrack frontendTrack = objectMapper.convertValue(feedback, FrontendTrack.class);
                feedbackDetails.setFeedbacks(frontendTrack);
                break;
        }

        return ResponseHandler.resHandler("Feedback posted successfully", HttpStatus.OK.value(), feedbackDetails, LocalDateTime.now());
    }
}
