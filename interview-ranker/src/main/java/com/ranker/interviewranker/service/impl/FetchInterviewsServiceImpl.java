package com.ranker.interviewranker.service.impl;

import com.ranker.interviewranker.domain.error.ErrorEntity;
import com.ranker.interviewranker.domain.request.interview.InterviewDetails;
import com.ranker.interviewranker.domain.response.ErrorResponseHandler;
import com.ranker.interviewranker.domain.response.ResponseHandler;
import com.ranker.interviewranker.service.FetchInterviewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class FetchInterviewsServiceImpl implements FetchInterviewsService {
    // TODO: Move this to application properties
    private static final String BASE_URL = "http://192.168.2.17:3000/interviews";

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public List<InterviewDetails> getAll() {
        log.debug("Inside function - getAllInterviews()");
        InterviewDetails[] interviewDetails = webClientBuilder.build()
                .get()
                .uri(BASE_URL)
                .retrieve()
                .bodyToMono(InterviewDetails[].class)
                .block();

        return List.of(interviewDetails);
    }

    @Override
    public ResponseEntity<Object> getAllInterviews() {
        List<InterviewDetails> interviews = getAll();

        if (interviews.isEmpty()) {
            log.error("No interview details fetched");
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT.toString(), "No interview details fetched"));
        }

        log.info("Total interviews fetched: " + interviews.size());
        return ResponseHandler.resHandler("Successfully fetched", HttpStatus.OK.value(), getAll(), (long) interviews.size(), LocalDateTime.now());
    }
}
