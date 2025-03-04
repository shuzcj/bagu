package com.Muti_Thread;

public class StopThread1 extends Thread {


    @Override
    public void run() {
        System.out.println("StopThread1.run()");
        try {
            Thread.sleep(5000);
            System.out.println("StopThread1.run() after sleep");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted while sleeping!");
            throw new RuntimeException(e);
        }

    }
}
