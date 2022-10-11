package com.ranker.interviewranker.repository;

import com.ranker.interviewranker.domain.dto.InterviewTrackDTO;
import com.ranker.interviewranker.domain.model.InterviewDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterviewsRepository extends MongoRepository<InterviewDetails, String> {
}
