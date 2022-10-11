package com.ranker.interviewranker.service;

import com.ranker.interviewranker.domain.dto.InterviewTrackDTO;
import com.ranker.interviewranker.domain.model.track.InterviewTrackFields;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InterviewTrackService {
    ResponseEntity<Object> saveInterviewTrackField(InterviewTrackDTO interviewTrackDTO);

    ResponseEntity<Object> getFieldsTrack();

    ResponseEntity<Object> getFieldsByTrack(String interviewTrack);

    ResponseEntity<Object> addFieldsInTracks(String interviewTrack, List<InterviewTrackFields> interviewTrackFields);

    ResponseEntity<Object> deleteFieldsInTracks(String interviewTrack, List<String> labelName);
}
