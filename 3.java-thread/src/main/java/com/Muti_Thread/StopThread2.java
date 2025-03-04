package com.Muti_Thread;

public class StopThread2 extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("StopThead2.run()");
        }
    }
}
