package com.ranker.interviewranker.service.impl;

import com.ranker.interviewranker.domain.error.ErrorEntity;
import com.ranker.interviewranker.domain.model.InterviewDetails;
import com.ranker.interviewranker.domain.model.Interviews;
import com.ranker.interviewranker.domain.response.ErrorResponseHandler;
import com.ranker.interviewranker.domain.response.ResponseHandler;
import com.ranker.interviewranker.service.ConsumerService;
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
public class ConsumerServiceImpl implements ConsumerService {
    // TODO: Move this to application properties
    private static final String BASE_URL = "http://192.168.2.17:3000/interviews";

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public ResponseEntity<Object> getAllInterviews() {
        Interviews interviews = new Interviews();
        List<InterviewDetails> allInterviews = List.of(getInterviews());

        if (allInterviews.isEmpty()) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT.toString(), "No interview details fetched"));
        }

        interviews.setInterviews(allInterviews);
        return ResponseHandler.resHandler("Successfully fetched", HttpStatus.OK.value(), interviews.getInterviews(), (long) allInterviews.size(), LocalDateTime.now());
    }

    private InterviewDetails[] getInterviews() {
        log.debug("Inside function - getInterview()");

        return webClientBuilder.build()
                .get()
                .uri(BASE_URL)
                .retrieve()
                .bodyToMono(InterviewDetails[].class)
                .block();
    }
}
