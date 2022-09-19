package com.ranker.interviewranker.domain.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    static final int VERSION = 1;
    public static ResponseEntity<Object> resHandler(String message, int status, Object responseObj, Long totalCount, LocalDateTime dateTime) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", status);
        res.put("message", message);
        res.put("data", responseObj);
        res.put("version", VERSION);
        res.put("total count", totalCount);
        res.put("date", dateTime);

        return new ResponseEntity<>(res, HttpStatus.valueOf(status));
    }

    public static ResponseEntity<Object> resHandler(String message, int status, Object responseObj, LocalDateTime dateTime) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", status);
        res.put("message", message);
        res.put("data", responseObj);
        res.put("version", VERSION);
        res.put("date", dateTime);

        return new ResponseEntity<>(res, HttpStatus.valueOf(status));
    }
}
