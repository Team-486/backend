package com.team486.traffic.error.area.exception;

import com.team486.traffic.common.error.code.ErrorCode;
import com.team486.traffic.common.error.exception.BusinessException;

public class AreaException extends BusinessException {
    public AreaException(final ErrorCode errorCode) {
        super(errorCode);
    }
}
