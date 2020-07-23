package com.example.demo.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Params {

    @NotEmpty(message = "params不能为空")
    @Valid
    List<Param> params;
}
