package com.market.place.exception;

import com.market.place.domain.error.ErrorCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Getter
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;
    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
