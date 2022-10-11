package com.ranker.interviewranker.controller;

import com.ranker.interviewranker.domain.dto.InterviewTrackDTO;
import com.ranker.interviewranker.service.InterviewTrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/")
public class InterviewTrackController {

    @Autowired
    private InterviewTrackService interviewTrackService;

    @PostMapping("/add/interview-track")
    public ResponseEntity<Object> addInterviewTrackField(@RequestBody InterviewTrackDTO interviewTrackDTO) {
        log.debug("Started function - insertInterviewTrackField()");
        return interviewTrackService.saveInterviewTrackField(interviewTrackDTO);
    }

    @GetMapping("/all/interview-tracks")
    public ResponseEntity<Object> getAllInterviewTracks() {
        log.debug("Started function - getAllInterviewTracks");
        return interviewTrackService.getFieldsTrack();
    }

    @GetMapping("/all/interview-tracks/{interviewTrack}")
    public ResponseEntity<Object> getInterviewTracksFieldsByTrack(@PathVariable String interviewTrack) {
        log.debug("Started function - getInterviewTracksFieldsByTrack");
        return interviewTrackService.getFieldsByTrack(interviewTrack);
    }
}
