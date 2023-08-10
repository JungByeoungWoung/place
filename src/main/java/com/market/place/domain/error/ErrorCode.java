package com.market.place.domain.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    ERR101("ERROR_101", "데이터 값이 잘못 되었습니다."),
    ERR102("ERROR_102", "중복 회원이 존재합니다."),
    ERR404("ERROR_404","해당 페이지를 찾을 수 없습니다."),
    ERR501("ERROR_501", "필수 값이 빠져있습니다.");

    private final String code;
    private final String message;
}
