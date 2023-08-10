package com.market.place.common;

import com.market.place.domain.error.ErrorCode;
import com.market.place.exception.CustomException;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    //글로벌 예외처리
    @ExceptionHandler(CustomException.class)
    public ErrorResponse handlerException(CustomException e) {
        return new ErrorResponse(e.getErrorCode(), e.getMessage());
    }
}
