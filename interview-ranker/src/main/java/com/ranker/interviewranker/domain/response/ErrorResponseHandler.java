package com.ranker.interviewranker.domain.response;

import com.ranker.interviewranker.domain.error.ErrorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponseHandler {

    public static ResponseEntity<Object> errorResponse(ErrorEntity errorEntity) {
        Map<String, ErrorEntity> errorMap = new HashMap<>();
        errorMap.put("error response", errorEntity);
        return new ResponseEntity<>(errorMap, errorEntity.getStatus());
    }
}
