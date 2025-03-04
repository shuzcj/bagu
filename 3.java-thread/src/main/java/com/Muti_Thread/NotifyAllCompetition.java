package com.Muti_Thread;

class NotifyAllCompetition {
    private final Object lock = new Object();

    void doWait() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                lock.wait();  // Thread enters WAITING state
                System.out.println("get the lock,and start sleep 3s");
                Thread.sleep(3000);  // Simulate work
                System.out.println(Thread.currentThread().getName() + " completed the sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void doNotifyAll() {
        synchronized (lock) {
            System.out.println("Notifying all threads...");
            lock.notifyAll();  // Wake up all waiting threads
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NotifyAllCompetition example = new NotifyAllCompetition();

        Thread t1 = new Thread(example::doWait, "Thread-1");
        Thread t2 = new Thread(example::doWait, "Thread-2");
        Thread t3 = new Thread(example::doWait, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);  // Ensure all threads are in WAITING state
        example.doNotifyAll();  // Notify all threads

        Thread.sleep(1000);  // Allow time to observe thread execution
    }
}
