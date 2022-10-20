package com.ranker.interviewranker.repository;

import com.ranker.interviewranker.domain.model.InterviewDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ConsumerRepository extends MongoRepository<InterviewDetails, String> {

    @Query("{'candidateName': ?0, 'interviewTrack': ?1}")
    List<InterviewDetails> findInterviewDetailsByCandidateName(String candidateName, String interviewTrackEnum);
}
