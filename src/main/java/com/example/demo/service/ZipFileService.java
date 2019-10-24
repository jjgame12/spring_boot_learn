package com.example.demo.service;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载接口
 * @author jj
 */
public interface ZipFileService {
    boolean download(String name, HttpServletResponse response);
}
