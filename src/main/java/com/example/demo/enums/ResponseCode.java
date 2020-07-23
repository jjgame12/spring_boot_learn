package com.example.demo.enums;

/**
 * http统一错误码
 */
public enum ResponseCode {
    SUCESS("0", "成功"),
    ERROR("1", "失败");

    private String code;
    private String description;

    private ResponseCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }
}
