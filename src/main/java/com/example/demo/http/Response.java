package com.example.demo.http;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义http统一返回
 * @param <T>
 */
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 600000000000001L;

    private String code;
    private T data;

    public Response(String code, T data) {
        this.code = code;
        this.data = data;
    }
}
