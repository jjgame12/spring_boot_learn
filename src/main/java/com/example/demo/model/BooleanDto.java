package com.example.demo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class BooleanDto {
    @NotNull(message = "isDto不能为空")
    private Boolean isDto;

    private int isIndex;

    @NotNull(message = "reg不能为空")
    @Pattern(regexp = "^[0-9]$", message = "reg只能为0-9")
    private String reg;

    @NotNull(message = "长度不能为空")
    @Length(min = 1, max = 6, message = "length长度在1-6之间")
    private String length;

    public void setIsDto(Boolean isDto) {
        this.isDto = isDto;
    }

    public Boolean getIsDto() {
        return isDto;
    }

    public void setIsIndex(int isIndex) {
        this.isIndex = isIndex;
    }

    public int getIsIndex() {
        return isIndex;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getReg() {
        return reg;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLength() {
        return length;
    }
}
