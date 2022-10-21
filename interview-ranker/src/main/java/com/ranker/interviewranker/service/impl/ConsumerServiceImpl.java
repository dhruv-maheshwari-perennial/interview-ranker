package com.ranker.interviewranker.service.impl;

import com.ranker.interviewranker.domain.error.ErrorEntity;
import com.ranker.interviewranker.domain.model.InterviewDetails;
import com.ranker.interviewranker.domain.response.ErrorResponseHandler;
import com.ranker.interviewranker.domain.response.ResponseHandler;
import com.ranker.interviewranker.repository.ConsumerRepository;
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
    private static final String BASE_URL = "http://192.168.29.96:3000/interviews";

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ConsumerRepository consumerRepository;


    @Override
    public ResponseEntity<Object> saveAllFetchInterviews() {
        List<InterviewDetails> allInterviews = List.of(getInterviews());

        if (allInterviews.isEmpty()) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT.toString(), "No interview details to save"));
        }

        consumerRepository.saveAll(allInterviews);
        return ResponseHandler.resHandler("Successfully fetched", HttpStatus.OK.value(), (long) allInterviews.size(), LocalDateTime.now());
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

    @Override
    public ResponseEntity<Object> saveInterview(InterviewDetails interviewDetails) {
        if (interviewDetails == null) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NOT_ACCEPTABLE, HttpStatus.NOT_ACCEPTABLE.toString(), "Interview details are invalid"));
        }

        consumerRepository.save(interviewDetails);
        return ResponseHandler.resHandler("Successfully Saved Interview in DB", HttpStatus.OK.value(), 1L, LocalDateTime.now());
    }

    @Override
    public ResponseEntity<Object> viewAllSavedInterviews() {
        List<InterviewDetails> allSavedInterviews = consumerRepository.findAll();

        if (allSavedInterviews.isEmpty()) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT.toString(), "No interview details fetched"));
        }

        return ResponseHandler.resHandler("Successfully fetched", HttpStatus.OK.value(), allSavedInterviews, (long) allSavedInterviews.size(), LocalDateTime.now(), 0L, 0L);
    }

    @Override
    public ResponseEntity<Object> updateInterview(String candidateName, String interviewTrack, InterviewDetails updatedInterviewDetails) {
        log.debug("Inside updateInterview()");
        List<InterviewDetails> interviewDetails = viewSingleInterview(candidateName, interviewTrack);

        if (interviewDetails.isEmpty()) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "No interview details found with this candidate name and interview track"));
        }

        log.info(interviewDetails.toString());
        consumerRepository.removeInterviewDetailsByCandidateNameAndInterviewTrack(candidateName, interviewTrack);
        consumerRepository.save(updatedInterviewDetails);
        return ResponseHandler.resHandler("Interview Details updated successfully", HttpStatus.OK.value(), updatedInterviewDetails, LocalDateTime.now());
    }

    @Override
    public ResponseEntity<Object> deleteInterview(String candidateName, String interviewTrack) {
        log.debug("Inside deleteInterview()");
        List<InterviewDetails> interviewDetails = viewSingleInterview(candidateName, interviewTrack);

        if (interviewDetails.isEmpty()) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "No interview details found with this candidate name and interview track"));
        }

        log.info(interviewDetails.toString());

        consumerRepository.removeInterviewDetailsByCandidateNameAndInterviewTrack(candidateName, interviewTrack);
        return ResponseHandler.resHandler("Interview Details deleted successfully", HttpStatus.OK.value(), interviewDetails, LocalDateTime.now());
    }

    @Override
    public ResponseEntity<Object> getSingleInterview(String candidateName, String interviewTrack) {
        log.debug("Inside getSingleInterview()");
        List<InterviewDetails> interviewDetails = viewSingleInterview(candidateName, interviewTrack);

        if (interviewDetails.isEmpty()) {
            return ErrorResponseHandler.errorResponse(new ErrorEntity(LocalDateTime.now(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.toString(), "No interview details found with this candidate name and interview track"));
        }

        return ResponseHandler.resHandler("Interview fetched successfully", HttpStatus.OK.value(), interviewDetails, LocalDateTime.now());
    }

    private List<InterviewDetails> viewSingleInterview(String candidateName, String interviewTrack) {
        return consumerRepository.findInterviewDetailsByCandidateName(candidateName, interviewTrack);
    }
}
