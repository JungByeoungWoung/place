package com.market.place.common.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode implements EnumCommon{
//    ERR102("ERROR_102", "중복 회원이 존재합니다."),

    INVALID_PARAM(400, "ERR400", "필수 파리미터 오류."),
    BAD_REQUEST(401, "ERR401", "잘못된 요청입니다."),
    NOT_FOUND(404,"ERR404","존재하지 않는 데이터 입니다."),

    REGISTER_FAILED(501,"ERR501","회원가입에 실패 했습니다.");

    private int status;
    private String errorCode;
    private String errorMsg;
    private String errorMsgDetail;
    ErrorCode(int status, String errorCode, String errorMsg) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getKey() {
        return this.errorCode;
    }

    @Override
    public String getValue() {
        return this.errorMsg;
    }
}
