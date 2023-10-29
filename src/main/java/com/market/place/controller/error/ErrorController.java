package com.market.place.controller.error;

import com.market.place.common.error.CustomException;
import com.market.place.common.error.ErrorCode;
import com.market.place.common.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * 공통 에러 처리 컨트롤
 * */
@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_PARAM);
        response.setErrorMsgDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleNoSuchElementException(Exception e) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.NOT_FOUND);
        response.setErrorMsgDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    /* Custom Error Handler */
    @ExceptionHandler(value = CustomException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorResponse response = ErrorResponse.of(e.getErrorCode());
        response.setErrorMsgDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
