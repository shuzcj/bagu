package com.Muti_Thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer  call() {
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += i;
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return sum;
    }
}
