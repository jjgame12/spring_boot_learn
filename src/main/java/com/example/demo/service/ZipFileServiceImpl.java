package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
@Service
public class ZipFileServiceImpl implements ZipFileService {
    @Override
    public boolean download(String name, HttpServletResponse response) throws Exception {
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

        // 清空response
        response.reset();
        //            response.setContentType("multipart/form-data");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(zipFile.getName().getBytes("UTF-8"),"ISO-8859-1"));

        try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(zipFile.getPath()));
//             ServletOutputStream som = response.getOutputStream();
             OutputStream toClient = new BufferedOutputStream(response.getOutputStream())) {
            log.info("开始读取文件流...");
            byte[] buffer = new byte[2048];
            int index = 0;
            while((index = fis.read(buffer)) != -1) {
                toClient.write(buffer, 0, index);
                toClient.flush();
            }
            log.info("数据流读取完毕");
            log.info("文件写入完毕");
            log.info("返回流刷新，关闭");
        } catch (IOException e) {
            log.error("IOException");
            return false;
        } catch (Exception e) {
            log.error("Exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public InputStream downloadStream(String name, HttpServletResponse response) {

        String realDir = new StringBuilder()
                .append("/Users/jj/workspace")
                .append("/")
                .append(name)
                .toString();
        log.info("文件路径[{}]", realDir);
        File zipFile = new File(realDir);
        if (!zipFile.exists()) {
            log.error("文件不存在");
            return null;
        }

        try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(zipFile.getPath()));
             OutputStream toClient = new BufferedOutputStream(response.getOutputStream())) {
            log.info("开始读取文件流...");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            log.info("buffer length = [{}]", buffer.length);
            // 清空response
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(zipFile.getName().getBytes("UTF-8"),"ISO-8859-1"));
            toClient.write(buffer);
            toClient.flush();
            log.info("stream -> [{}]", fis.toString());
            return fis;
        } catch (IOException e) {
            log.error("IOException");
            return null;
        } catch (Exception e) {
            log.error("Exception");
            return null;
        }
    }
}
