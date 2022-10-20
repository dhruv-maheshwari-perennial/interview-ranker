package com.ranker.interviewranker.service.impl;

import com.ranker.interviewranker.domain.dto.InterviewTrackDTO;
import com.ranker.interviewranker.domain.error.ErrorEntity;
import com.ranker.interviewranker.domain.model.track.InterviewTrackFields;
import com.ranker.interviewranker.domain.response.ErrorResponseHandler;
import com.ranker.interviewranker.domain.response.ResponseHandler;
import com.ranker.interviewranker.repository.InterviewTrackRepository;
import com.ranker.interviewranker.service.InterviewTrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InterviewTrackServiceImpl implements InterviewTrackService {

    @Autowired
    private InterviewTrackRepository interviewTrackRepository;

    @Override
    public ResponseEntity<Object> saveInterviewTrackField(InterviewTrackDTO interviewTrackDTO) {
        log.debug("Inside Service: saveInterviewTrackField()");
        log.info("Interview Track: " + interviewTrackDTO.toString());

        if (interviewTrackDTO.getInterviewTrack().toString().isEmpty()) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NOT_ACCEPTABLE, HttpStatus.NOT_ACCEPTABLE.toString(), "Interview track cannot be null or empty"));
        }

        interviewTrackDTO.setCreatedAt(LocalDateTime.now());
        interviewTrackDTO.setUpdatedAt(LocalDateTime.now());
        InterviewTrackDTO result = interviewTrackRepository.insert(interviewTrackDTO);
        return ResponseHandler.resHandler("Successfully saved in db", HttpStatus.OK.value(), result, (long) interviewTrackDTO.getInterviewTrackFieldsList().size(), LocalDateTime.now(), 0L, 0L);
    }

    @Override
    public ResponseEntity<Object> getFieldsTrack() {
        log.debug("Inside Service: getFieldsTrack()");
        List<String> interviewTrackEnums = new ArrayList<>();
        interviewTrackRepository.findAll().forEach(interviewTrackDTO -> interviewTrackEnums.add(interviewTrackDTO.getInterviewTrack()));

        if (interviewTrackEnums.isEmpty()) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT.toString(), "Interview track cannot be null or empty"));
        }

        log.info("Interview Track List: " + interviewTrackEnums);
        return ResponseHandler.resHandler("Successfully fetched from db", HttpStatus.OK.value(), interviewTrackEnums, (long) interviewTrackEnums.size(), LocalDateTime.now(), 0L, 0L);
    }

    @Override
    public ResponseEntity<Object> getFieldsByTrack(String interviewTrack) {
        log.debug("Inside Service: getFieldsByTrack()");
        InterviewTrackDTO interviewTrackDTOByInterviewTrack = interviewTrackRepository.getInterviewTrackDTOByInterviewTrack(interviewTrack).get(0);

        if (interviewTrackDTOByInterviewTrack == null) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "No interview track fields found for this track: " + interviewTrack));
        }

        log.info("Interview Track Fields List: " + interviewTrackDTOByInterviewTrack);
        return ResponseHandler.resHandler("Successfully fetched from db", HttpStatus.OK.value(), interviewTrackDTOByInterviewTrack, LocalDateTime.now(), 0L, 0L);
    }

    @Override
    public ResponseEntity<Object> addFieldsInTracks(String interviewTrack, List<InterviewTrackFields> interviewTrackFields) {
        log.debug("Inside Service: addFieldsInTracks()");

        InterviewTrackDTO interviewTrackDTO = interviewTrackRepository
                .getInterviewTrackDTOByInterviewTrack(interviewTrack)
                .get(0);

        if (interviewTrackDTO == null) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "No interview track fields found for this track: " + interviewTrack));
        }

        interviewTrackDTO.getInterviewTrackFieldsList().addAll(interviewTrackFields);
        interviewTrackDTO.setUpdatedAt(LocalDateTime.now());

        log.info("Interview Track Fields List: " + interviewTrackDTO);
        return ResponseHandler.resHandler("Successfully added new interview fields", HttpStatus.OK.value(), interviewTrackDTO, LocalDateTime.now(), 0L, 0L);
    }

    @Override
    public ResponseEntity<Object> deleteFieldsInTracks(String interviewTrack, List<String> labelName) {
        log.debug("Inside Service: deleteFieldsInTracks()");

        InterviewTrackDTO interviewTrackDTO = interviewTrackRepository
                .getInterviewTrackDTOByInterviewTrack(interviewTrack)
                .get(0);

        if (interviewTrackDTO == null) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "No interview track fields found for this track: " + interviewTrack));
        }

        interviewTrackDTO.getInterviewTrackFieldsList().removeAll(labelName);
        interviewTrackDTO.setUpdatedAt(LocalDateTime.now());

        log.info("Interview Track Fields List: " + interviewTrackDTO);
        return ResponseHandler.resHandler("Successfully deleted interview fields", HttpStatus.OK.value(), interviewTrackDTO, LocalDateTime.now(), 0L, 0L);
    }
}
