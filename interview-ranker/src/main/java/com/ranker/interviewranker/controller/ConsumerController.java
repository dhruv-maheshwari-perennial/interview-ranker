package com.ranker.interviewranker.controller;

import com.ranker.interviewranker.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConsumerController Class - controller for consuming 3rd party interview api from fake node json server.
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    /**
     * getAllInterviews() method call the API which returns the array or list of interviews
     */
    @GetMapping("/fetch/interviews")
    public ResponseEntity<Object> fetchInterviews() {
        log.debug("Started function - getInterviews()");
        return consumerService.getAllInterviews();
    }
}
