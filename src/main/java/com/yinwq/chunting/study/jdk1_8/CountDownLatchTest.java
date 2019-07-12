package com.yinwq.chunting.study.jdk1_8;

import com.yinwq.chunting.common.util.BT;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/6/18 11:10
 */
@Log4j
public class CountDownLatchTest {
    public static void main(String[] args) {

        log.error("==========" + BT.getCurrentDateTime());
        final CountDownLatch counter = new CountDownLatch(3);
        newFixedThreadPool(10).submit(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                do {
                    i++;
                    try {
                        System.err.println("休眠1秒");
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        log.error(e);
                    } finally {
                        System.err.println("计数器减1");
                        counter.countDown();
                    }
                }while (i < 3);

            }
        });

        try {
            counter.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("异步链路等待异常:{}", e);
        }

        log.error("==========" + BT.getCurrentDateTime());
    }
}
