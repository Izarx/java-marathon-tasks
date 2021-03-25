package com.softserve.itacademy.stage8.ex3;

public class ThreadExample {

    public static void threadRun () {
        Interactor interactor = new Interactor();
        Thread t1 = new Thread(() -> {
            try {
                interactor.serve(x -> -x+4, 11);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try
            {
                interactor.consume((a, b) -> a+2*b, 20);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        try
        {
            t2.start();
            t1.start();
            t2.join();
            t1.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        threadRun();
    }
}
