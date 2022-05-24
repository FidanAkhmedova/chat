package ru.geekbrains.java_two.lesson_e.online;

public class ThreadMain {
    static class MyThread extends Thread {
        int sleep;
        MyThread(String name, int sleep) {
            super(name);
            this.sleep = sleep;
        }
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    sleep(sleep);
                    System.out.println("finish " + Thread.currentThread().getName());
                    interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static long a;
    private static long b;
    private static long c;

    private synchronized static void incAll() {
        for (int i = 0; i < 10_000_000; i++) {
            a = a + 1;
            b = b + 1;
            c = c + 1;
        }
        String values = String.format("a=%d, b=%d, c=%d", a, b, c);
        System.out.println(values);
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello " + Thread.currentThread().getName());
        Runnable r0 = ThreadMain::incAll;

        new Thread(r0, "thread #1").start();
        new Thread(r0, "thread #2").start();
        Thread t = new Thread(r0, "thread #3");
        t.start();




//        MyThread mt1 = new MyThread("mt2", 2000);
//        MyThread mt2 = new MyThread("mt3", 3000);
//        MyThread mt3 = new MyThread("mt1", 1000);
//        MyThread mt4 = new MyThread("mt4", 4000);
//        mt1.start();
//        mt2.start();
//        mt3.start();
//        mt4.start();
//
//        try {
//            mt1.join();
//            mt2.join();
//            mt3.join();
//            mt4.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Goodbye " + Thread.currentThread().getName());

//        MyThread myThread = new MyThread("My-thread", 10);
////        myThread.hello();
//        myThread.run();
//        myThread.start();
//        new MyThread("My-thread-2", 10).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello " + Thread.currentThread().getName());
//            }
//        }, "My-thread-3").start();
//
//        myThread.stop();
//        myThread.interrupt();
    }
}
