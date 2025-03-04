package com.Muti_Thread;

public class StopThread3 extends Thread {

    public volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("StopThread3.run()");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stopThread() {
        stop = true;
    }
}
