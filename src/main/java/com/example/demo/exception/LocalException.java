package com.example.demo.exception;

import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class LocalException extends Exception {
    private String exceptionName;

    public LocalException(String name) {
        super();
        exceptionName = name;
    }
}
