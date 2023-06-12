package com.sy.rest_api_example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    DEPOSIT_WAITING("입금대기"),
    DEPOSIT_INSUFFICIENT("입금금액부족"),
    SUCCESS("결제완료"),
    CANCEL("주문취소");

    private String name;
}
