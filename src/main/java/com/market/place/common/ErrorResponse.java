package com.market.place.common;

import com.market.place.domain.error.ErrorCode;
import com.market.place.exception.CustomException;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@RequiredArgsConstructor
@Builder
public class ErrorResponse{
    private final ErrorCode code;
    private final String message;
    @Builder
    public ErrorResponse(ErrorCode errorCode) {
        this.code = ErrorCode.valueOf(errorCode.getCode());
        this.message = errorCode.getMessage();
    }

}
