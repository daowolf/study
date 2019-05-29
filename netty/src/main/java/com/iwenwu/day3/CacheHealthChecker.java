package com.iwenwu.day3;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: BigDaddy
 * @Date: 2019/5/29 18:10
 * @Description:
 */
public class CacheHealthChecker extends BaseHealthChecker {
    public CacheHealthChecker(CountDownLatch latch)  {
        super("CacheHealth Service", latch);
    }

    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
