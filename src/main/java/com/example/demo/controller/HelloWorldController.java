package com.example.demo.controller;

import com.example.demo.mapper.JobsMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Jobs;
import com.example.demo.model.User;
import com.example.demo.service.BeanService;
import com.example.demo.service.GlobalService;
import com.example.demo.service.ZipFileService;
import com.example.demo.service.ZipFileServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jj
 */
@RestController
@Slf4j
public class HelloWorldController {
//    @Autowired
    private static Environment environment;

    @Autowired
    private BeanService beanService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JobsMapper jobsMapper;

    @Autowired
    private ZipFileService fileService;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/data")
    public String getData() {
        return environment.getProperty("localData.name");
    }

    @GetMapping("/bean")
    public String getLocalData() {
        return beanService.getName();
    }

    @GetMapping("/name")
    public String getLocalName() {
        log.info("name -> [{}]", GlobalService.getName());
        return GlobalService.getName();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userMapper.getOne(id);
    }

    @GetMapping("/getSimple/{id}")
    public User getSimpleOne(@PathVariable("id") Long id) {
        return userMapper.getSimpleOne(id);
    }

    @GetMapping("/getJob/{id}")
    public Jobs getJob(@PathVariable("id") Long id) {
        return jobsMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/download/{fileName}")
    public void downloadGet(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
        download(fileName, request, response);
    }

    @PostMapping("/download/{fileName}")
    public void download(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
        boolean successful = fileService.download(fileName, response);
        log.info("文件下载结果[{}]", successful);
    }
}

