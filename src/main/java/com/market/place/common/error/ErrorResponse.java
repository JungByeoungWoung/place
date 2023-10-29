package com.market.place.common.error;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 동일한 포맷으로 에러메시지를 응답하기 위한 클래스
 * */
@Data
@NoArgsConstructor
public class ErrorResponse{
    private int status;
    private String errorCode;
    private String errorMsg;
    private String errorMsgDetail;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.errorCode = errorCode.getErrorCode();
        this.errorMsg = errorCode.getErrorMsg();
        this.errorMsgDetail = errorCode.getErrorMsgDetail();
    }
    /**
     * Enum인 에러코드를 param으로 받아서
     * ErrorResponse 객체를 생성해줌.
     * */
    public static ErrorResponse of(ErrorCode errorCode) {
        return new ErrorResponse();
    }
}
