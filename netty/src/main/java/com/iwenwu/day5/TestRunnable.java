package com.iwenwu.day5;

/**
 * @Auther: BigDaddy
 * @Date: 2019/6/6 14:11
 * @Description:
 */
public class TestRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
    }
}
