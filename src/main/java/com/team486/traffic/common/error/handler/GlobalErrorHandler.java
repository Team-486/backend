package com.team486.traffic.common.error.handler;

import com.team486.traffic.common.error.code.ErrorCode;
import com.team486.traffic.common.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {
    private static final String LOG_FORMAT = "class = {}, message = {}, status = {}";

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException e) {
        final ErrorCode errorCode = e.getErrorCode();
        log.error(LOG_FORMAT, e.getClass(), errorCode.getMessage(), errorCode.getStatus());
        return ResponseEntity.status(errorCode.getStatus())
                .body(errorCode);
    }
}
