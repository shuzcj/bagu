package com.Muti_Thread;

import java.util.concurrent.FutureTask;

public class MyThread extends Thread {

    MyThread(String name) {
        super(name);
    }



    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(getName() + " " + i);
        }
    }
}
