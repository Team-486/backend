package com.team486.traffic.error.area.code;

import com.team486.traffic.common.error.code.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum AreaErrorCode implements ErrorCode {
    NOT_FOUND("NOT_FOUND", "도로를 찾을 수 없습니다", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;

    AreaErrorCode(final String code, final String message, final HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
