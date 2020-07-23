package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试使用servlet方式的请求是否不会受到@ControllerAdvice的影响
 * 答案：不会
 * @author jj
 */
@WebServlet(urlPatterns = "/ss", name = "ss")
@Slf4j
public class ServletController extends HttpServlet {
    private static final long serialVersionUID = 12332112332123L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        log.info("get...");
//        throw new ServletException("servlet test");

        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            log.error("IO exception");
            return;
        }

        writer.write("ss");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
