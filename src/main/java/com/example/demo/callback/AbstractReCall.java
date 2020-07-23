package com.example.demo.callback;

import lombok.extern.slf4j.Slf4j;

/**
 * 回调基类
 * @author jj
 */
@Slf4j
public abstract class AbstractReCall {
    private static int global = 0;

    public void setGlobal(int tglobal) {
        global = tglobal;
    }

    public void doing() {
        new Thread(() -> {
            while (true) {
                if (global == 1) {
                    log.info("状态改变，开始执行回调");
                    // 回调时调用
                    recall();
                    global = 0;
                }
            }
        }).start();
    }

    /**
     * 需要由子类实现的方法，回调时调用
     */
    public abstract void recall();
}
