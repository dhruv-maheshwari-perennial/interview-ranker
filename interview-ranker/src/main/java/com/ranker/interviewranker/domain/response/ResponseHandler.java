package com.ranker.interviewranker.domain.response;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {
    //TODO: MOVE THIS APPLICATION PROPERTIES
    private static final int VERSION = 1;

    public static ResponseEntity<Object> resHandler(String message, int status, Object responseObj, Long totalCount, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime dateTime, Long numberOfItems, Long numberOfPage) {
        Map<String, Object> res = new LinkedHashMap<>();
        res.put("status", status);
        res.put("totalCount", totalCount);
        res.put("body", responseObj);
        res.put("message", message);
        res.put("date", dateTime);
        res.put("version", VERSION);
        res.put("currentPage", numberOfPage);
        res.put("totalPages", numberOfItems);

        return new ResponseEntity<>(res, HttpStatus.valueOf(status));
    }

    public static ResponseEntity<Object> resHandler(String message, int status, Object responseObj, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime dateTime, Long numberOfItems, Long numberOfPage) {
        Map<String, Object> res = new LinkedHashMap<>();
        res.put("status", status);
        res.put("body", responseObj);
        res.put("message", message);
        res.put("date", dateTime);
        res.put("version", VERSION);
        res.put("currentPage", numberOfPage);
        res.put("totalPages", numberOfItems);

        return new ResponseEntity<>(res, HttpStatus.valueOf(status));
    }

    public static ResponseEntity<Object> resHandler(String message, int status, Long totalCount, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime dateTime) {
        Map<String, Object> res = new LinkedHashMap<>();
        res.put("status", status);
        res.put("totalCount", totalCount);
        res.put("message", message);
        res.put("date", dateTime);
        res.put("version", VERSION);

        return new ResponseEntity<>(res, HttpStatus.valueOf(status));
    }

    public static ResponseEntity<Object> resHandler(String message, int status, Object responseObj, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime dateTime) {
        Map<String, Object> res = new LinkedHashMap<>();
        res.put("status", status);
        res.put("body", responseObj);
        res.put("message", message);
        res.put("date", dateTime);
        res.put("version", VERSION);

        return new ResponseEntity<>(res, HttpStatus.valueOf(status));
    }
}
