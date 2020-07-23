package com.callback;

import lombok.extern.slf4j.Slf4j;

/**
 * 回调基类
 */
@Slf4j
public class ReCall {
    private static int global = 0;

    public void doing() {
        new Thread(() -> {
            while (true) {
                if (global == 1) {
                    log.info("状态改变，开始执行回调");
                    recall();
                }
            }
        }).start();
    }

    public void recall() {
        log.info("**********base recall");
    }
}

@Slf4j
class RecallImpl extends ReCall {
    public void recall() {
        log.info("----------impl recall");
    }
}
