package com.example.demo.callback;

import lombok.extern.slf4j.Slf4j;

/**
 * 实现回调的方法
 * @author jj
 */
@Slf4j
public class ReCallImpl extends AbstractReCall {
    @Override
    public void recall() {
        log.info("----------impl recall");
    }
}
