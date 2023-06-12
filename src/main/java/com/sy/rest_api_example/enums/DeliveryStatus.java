package com.sy.rest_api_example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum DeliveryStatus {

    READY("배송준비중"),
    ING("배송중"),
    COMPLETE("배송완료"),
    CANCEL("취소"),

    EMPTY("없음");

    private String name;
}
