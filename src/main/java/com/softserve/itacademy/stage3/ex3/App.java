package com.softserve.itacademy.stage3.ex3;

public class App {

    public static void main(String[] args)
    {
        App.addAtoB(2, 3);
    }

    public static void execute (int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }

    public static void addAtoB(int a, int b) {

        // Write your code here
        execute (a, b, new Strategy () {

            @Override
            public double doOperation(int a, int b) {
                return (double) a + b;
            }
        });

    }

    public static void subtractBfromA(int a, int b) {

        // Write your code here
        execute (a, b, new Strategy () {

            @Override
            public double doOperation(int a, int b) {
                return (double) a - b;
            }
        });

    }

    public static void multiplyAbyB(int a, int b) {

        // Write your code here
        execute (a, b, new Strategy () {

            @Override
            public double doOperation(int a, int b) {
                return (double) a * b;
            }
        });

    }

    public static void divideAbyB(int a, int b) {

        // Write your code here
        execute (a, b, new Strategy () {

            @Override
            public double doOperation(int a, int b) {
                return (double) a / b;
            }
        });

    }

    interface Strategy {
        double doOperation (int a, int b);
    }

}
