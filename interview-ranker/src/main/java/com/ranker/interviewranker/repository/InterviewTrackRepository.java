package com.ranker.interviewranker.repository;

import com.ranker.interviewranker.domain.dto.InterviewTrackDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface InterviewTrackRepository extends MongoRepository<InterviewTrackDTO, String> {
}
