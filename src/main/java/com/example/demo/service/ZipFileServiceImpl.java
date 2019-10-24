package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
@Service
public class ZipFileServiceImpl implements ZipFileService {
    @Override
    public boolean download(String name, HttpServletResponse response) {
        String realDir = new StringBuilder()
                .append("/Users/jj/workspace")
                .append("/")
                .append(name)
                .toString();
        log.info("文件路径[{}]", realDir);
        File zipFile = new File(realDir);
        if (!zipFile.exists()) {
            log.error("文件不存在");
            return false;
        }

        BufferedInputStream fis = null;
        OutputStream toClient = null;
        try {
            log.info("开始读取文件流...");
            fis = new BufferedInputStream(new FileInputStream(zipFile.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            log.info("数据流读取完毕");
            // 清空response
            response.reset();
            toClient = new BufferedOutputStream(response.getOutputStream());
//            response.setContentType("application/octet-stream");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(zipFile.getName().getBytes("UTF-8"),"ISO-8859-1"));
            toClient.write(buffer);
            log.info("文件写入完毕");
            toClient.flush();
            toClient.close();
            log.info("返回流刷新，关闭");
        } catch (IOException e) {
            log.error("IOException");
            return false;
        } catch (Exception e) {
            log.error("Exception");
            return false;
        }

        return true;
    }
}
