package com.sy.rest_api_example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayType {

    CARD("카드"),
    VIRTUAL_ACCOUNT("가상계좌"),
    ACCOUNT_TRANSFER("계좌이체"),
    MOBILE_PHONE("휴대폰"),
    KAKAO_PAY("카카오페이"),
    NAVER_PAY("네이버페이"),
    PAYCO("페이코");

    private String name;

}
