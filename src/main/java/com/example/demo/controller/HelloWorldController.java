package com.example.demo.controller;

import com.example.demo.mapper.JobsMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.*;
import com.example.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author jj
 */
@RestController
@Slf4j
public class HelloWorldController {
    @Autowired
    private Environment environment;

    @Autowired
    private BeanService beanService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JobsMapper jobsMapper;

    @Autowired
    private ZipFileService fileService;

    @Resource
    private ResourceService resourceService;

    @Resource
    private NoDefaultConstructorClass noDefaultConstructorClass;

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

    @PostMapping("/insert")
    public void insert(@RequestBody User user) {
        userMapper.insert(user);
    }

    @GetMapping("/getJob/{id}")
    public Jobs getJob(@PathVariable("id") Long id) {
        return jobsMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/download/{fileName}")
    public void downloadGet(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        download(fileName, request, response);
    }

    @PostMapping("/download/{fileName}")
    public void download(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean successful = fileService.download(fileName, response);
        log.info("文件下载结果[{}]", successful);
        if (successful) {
            return;
        }

        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append("no file");
        } catch (Exception e) {
            log.error("写入返回失败");
        } finally {
            if (null != out) {
                out.close();
            }
        }

        log.info("写入返回成功");
    }

    @GetMapping("/stream/{fileName}")
    public void downloadStream(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream stream = fileService.downloadStream(fileName, response);
        if (null != stream) {
            log.info("stream------");
            log.info(stream.toString());
        }

        // 流已关闭 继续用会抛出异常
//        byte[] buffer = new byte[stream.available()];
//        log.info("before -> [{}]", buffer.length);
//        stream.read(buffer);
//        log.info("buffer length = [{}]", buffer.length);
//        stream.close();
    }

    @GetMapping("/resource")
    public String getResource() {
        return resourceService.print();
    }

    @Resource
    private AnnotationService annotationService;

    @GetMapping("/getresource")
    public String getRes() {
        return annotationService.getResource();
    }

    @DeleteMapping("/delete")
    public String deleteTest(@RequestParam int i) {
        log.info("i = [{}]", i);
        return "yes";
    }

    @DeleteMapping("/delete/body")
    public String deleteBody(@RequestBody @Valid DeleteBody body) {
        log.info("body = [{}]", body);
        return "abc";
    }

    @PostMapping("/boolean")
    public String testBoolean(@RequestBody @Valid BooleanDto req) {
        log.info("req.isDto = [{}]", req.getIsDto());
        log.info("req.index = [{}]", req.getIsIndex());
        log.info("req.reg = [{}]", req.getReg());
        log.info("req.length = [{}]", req.getLength());

        return "yes";
    }

    @PostMapping("/validParam")
    public String validParam(@RequestBody @Valid Params params) {
        log.info("params = [{}]", params);
        return "yes";
    }
}

