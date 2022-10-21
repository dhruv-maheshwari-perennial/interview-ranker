package com.ranker.interviewranker.controller;

import com.ranker.interviewranker.domain.model.InterviewDetails;
import com.ranker.interviewranker.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/save/all/interview")
    public ResponseEntity<Object> saveAllInterviews() {
        log.debug("Started function - getInterviews()");
        return consumerService.saveAllFetchInterviews();
    }

    @GetMapping("/view/interview")
    public ResponseEntity<Object> viewInterviews() {
        log.debug("Started function - viewInterviews()");
        return consumerService.viewAllSavedInterviews();
    }

    @GetMapping("/view/single/interview/{candidateName}/{interviewTrack}")
    public ResponseEntity<Object> viewSingleInterviews(@PathVariable String candidateName, @PathVariable String interviewTrack) {
        log.debug("Started function - viewSingleInterviews()");
        return consumerService.getSingleInterview(candidateName, interviewTrack);
    }

    @PostMapping("/save/interview")
    public ResponseEntity<Object> saveInterview(@RequestBody InterviewDetails interviewDetails) {
        log.debug("Started function - saveInterview()");
        return consumerService.saveInterview(interviewDetails);
    }

    @PutMapping("/update/interview/{candidateName}/{interviewTrack}")
    public ResponseEntity<Object> updateInterview(@PathVariable String candidateName, @PathVariable String interviewTrack, @RequestBody InterviewDetails interviewDetails) {
        log.debug("Started function - updateInterview()");
        return consumerService.updateInterview(candidateName, interviewTrack, interviewDetails);
    }

    @DeleteMapping("/delete/interview/{candidateName}/{interviewTrack}")
    public ResponseEntity<Object> deleteInterview(@PathVariable String candidateName, @PathVariable String interviewTrack) {
        log.debug("Started function - deleteInterview()");
        return consumerService.deleteInterview(candidateName, interviewTrack);
    }
}
