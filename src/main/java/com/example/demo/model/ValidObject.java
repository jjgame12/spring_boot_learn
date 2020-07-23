package com.example.demo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class ValidObject {
    @NotBlank(message = "name不能为空")
    @Length(max = 5, min = 1, message = "长度在1-5之间")
    private String name;

    @NotBlank(message = "id不能为空")
    private String id;
}
