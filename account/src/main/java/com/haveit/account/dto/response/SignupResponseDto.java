package com.haveit.account.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter //없으면 406에러
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자를 자동으로 생성
public class SignupResponseDto {
    private Long memberId;
    private String message;
}
