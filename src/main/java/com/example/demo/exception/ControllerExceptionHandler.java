package com.example.demo.exception;

import com.example.demo.enums.ResponseCode;
import com.example.demo.http.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * controller统一异常处理类
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    @ExceptionHandler(LocalException.class)
    @ResponseBody
    public Response<String> jsonErrorHandler(HttpServletRequest request, LocalException e) {
        log.info("e1 => [{}]", e.toString());
        return new Response<>(ResponseCode.ERROR.getCode(), e.getExceptionName());
    }

    @ExceptionHandler(ServletException.class)
    @ResponseBody
    public Response<String> jsonErrorHandler(HttpServletRequest request, ServletException e) {
        log.info("servlet error => [{}]", e.toString());
        return new Response<>(ResponseCode.ERROR.getCode(), e.getMessage());
    }

    /**
     * controller参数校验器异常返回统一格式处理
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response validationBodyException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                log.error("Data check failure : object={}, field={}, errorMessage={}", fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            });
            return new Response<>(ResponseCode.ERROR.getCode(),
                    result.getFieldError() == null ? "请求参数有误" : result.getFieldError().getDefaultMessage());
        }
        //其他错误
        return new Response<>(ResponseCode.ERROR.getCode(), "未知错误");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response normalExceptionHandler(Exception e) {
        log.info("e2 => [{}], [{}]", e.toString(), e.getClass().getName());
        return new Response<>(ResponseCode.ERROR.getCode(), e.toString());
    }
}
