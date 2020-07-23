package com.example.demo.controller;

import com.example.demo.http.Response;
import com.example.demo.model.ValidObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.demo.enums.ResponseCode.SUCESS;

@RestController
@Slf4j
public class ValidController {
    /**
     * 测试校验器与校验异常格式化返回
     * @param req
     * @return
     */
    @PostMapping("/valid")
    public Response testValid(@RequestBody @Valid ValidObject req) {
        log.info("req = [{}]", req);
        return new Response<>(SUCESS.getCode(), "");
    }
}
