package com.ranker.interviewranker.domain.error;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorEntity {
    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String error;
    private String errorMsg;
//    private Exception exception;
//    private String path;
//    "timestamp": 1488058582764,
//            "status": 429,
//            "error": "Too Many Requests",
//            "exception": "com.example.ExternalRateLimitException",
//            "message": "DAILY_LIMIT: too many requests",
//            "path": "/api/lookup",
//            "type": "DAILY_LIMIT"
}
