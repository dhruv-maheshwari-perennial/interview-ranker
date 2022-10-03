package com.ranker.interviewranker.service.impl;

import com.ranker.interviewranker.domain.dto.InterviewTrackDTO;
import com.ranker.interviewranker.domain.error.ErrorEntity;
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
        return ResponseHandler.resHandler("Successfully saved in db", HttpStatus.OK.value(), result, (long) interviewTrackDTO.getInterviewTrackFieldsList().size(), LocalDateTime.now());
    }

    // 1. Add New Field
    // 2. Bulk Add New Fields
    // 3. Delete Field
    // 4. Bulk delete Fields
    // 5. Update Field
    // 6. Bulk Update Fields
    // 7. Get Fields by Track
    // 8. Get Fields Track
}
