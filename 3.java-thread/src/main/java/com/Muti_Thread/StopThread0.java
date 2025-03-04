package com.Muti_Thread;

public class StopThread0 extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            while(!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName() + " !Thread.currentThread().isInterrupted()" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
