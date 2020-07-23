package com.example.demo.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Param {
    @NotBlank(message = "param.a不能为空")
    private String a;

    @NotNull(message = "param.index不能为空")
    private Integer index;
}
