package com.example.demo.controller;

import com.example.demo.service.AnnotationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/security")
public class SpringSecController {
    @Autowired
    private AnnotationService annotationService;

    @Autowired
    public void getAnnotationService(AnnotationService service) {
        service.setId(3);
//        annotationService = service;
        log.info("**********set annotation id...");
    }

    @GetMapping("/autowired")
    public Map getAutowiredFunc() {
        HashMap<String, Integer> result = new HashMap<>();
        if (null == annotationService) {
            log.info("******current annotation = null");
            result.put("result", null);
            return result;
        }

        log.info("******current annotation id = [{}]", annotationService.getId());
        result.put("result", annotationService.getId());
        return result;
    }
}
