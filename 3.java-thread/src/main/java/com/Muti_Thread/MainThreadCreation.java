package com.Muti_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MainThreadCreation {

    static void testThreadsCreation1() {
        MyThread myThread = new MyThread("name1");
        myThread.start();
    }

    static void testThreadsCreation2() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "name2");
        thread.start();
    }

    static void testThreadsCreation3() {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask, "name3");
        thread.start();
        try {
            Integer result = futureTask.get();
            System.out.println("result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void testThreadsCreation4() {
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService.submit(myRunnable);
        executorService.submit(myRunnable);
        executorService2.submit(myRunnable);
    }

    public static void main(String[] args) {
        //testThreadsCreation1();
        //testThreadsCreation2();
        //testThreadsCreation3();
        testThreadsCreation4();

    }
}
