package com.sy.rest_api_example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {

    private Long crePsPid;
    private LocalDateTime creDtm;
    private Long modPsPid;
    private LocalDateTime modDtm;

}
