package com.example.demo.controller.servletfilter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@WebFilter("/ss")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        BufferedReader reader = servletRequest.getReader();
        StringBuilder content = new StringBuilder();
        String line = null;
        while((line = reader.readLine()) != null) {
            content.append(line);
        }
        String body = content.toString();
        log.info("request body = [{}]", body);
        log.info("filter passed...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
