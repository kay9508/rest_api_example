package com.sy.rest_api_example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO extends BaseDTO implements Serializable {

    private Long id;

    private String title;

    private String content;

    private Boolean delAt;
}