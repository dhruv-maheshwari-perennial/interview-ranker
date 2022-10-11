package com.ranker.interviewranker.repository;

import com.ranker.interviewranker.domain.dto.InterviewTrackDTO;
import com.ranker.interviewranker.enums.InterviewTrackEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface InterviewTrackRepository extends MongoRepository<InterviewTrackDTO, String> {
    @Query("{interviewTrack:  ?0}")
    List<InterviewTrackDTO> getInterviewTrackDTOByInterviewTrack(InterviewTrackEnum interviewTrack);
}
