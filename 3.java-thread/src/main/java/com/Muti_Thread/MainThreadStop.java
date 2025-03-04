package com.Muti_Thread;

public class MainThreadStop {

    void testThreadStop() throws InterruptedException {
        StopThread0 stopThread0 = new StopThread0();
        stopThread0.start();
        Thread.sleep(2000);
        stopThread0.interrupt();
    }

    void testThreadStop2() throws InterruptedException {
        StopThread1 stopThread1 = new StopThread1();
        stopThread1.start();
        Thread.sleep(2000);
        stopThread1.interrupt();
    }

    void testThreadStop3() throws InterruptedException {
        StopThread2 stopThread2 = new StopThread2();
        stopThread2.start();
        Thread.sleep(2000);
        stopThread2.stop();// Dangerous! Forcefully stops the thread
    }

    void testThreadStop4() throws InterruptedException {
        StopThread3 stopThread3 = new StopThread3();
        stopThread3.start();
        Thread.sleep(2000);
        stopThread3.stopThread();
    }

    public static void main(String[] args) {
        MainThreadStop mainThreadStop = new MainThreadStop();

        try {
            //mainThreadStop.testThreadStop();
            //mainThreadStop.testThreadStop2();
            //mainThreadStop.testThreadStop3();
            //mainThreadStop.testThreadStop4();
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread is running");
            });
            thread.start();
            Thread.sleep(1000);
            System.out.println(thread.getState());
            thread.start();
            System.out.println(thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
