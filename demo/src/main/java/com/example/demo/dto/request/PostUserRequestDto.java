package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUserRequestDto {
    @JsonIgnore
    private Integer id;

    private String name;

    private Integer age;

    private String introduce;
}
