package com.ranker.interviewranker.controller;

import com.ranker.interviewranker.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback/{candidateName}")
    public ResponseEntity<Object> postInterviewFeedback(@PathVariable String candidateName, @RequestBody Object responseBody) {
        return feedbackService.addFeedback(candidateName, responseBody);
    }
}
