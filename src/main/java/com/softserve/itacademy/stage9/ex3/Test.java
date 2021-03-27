package com.softserve.itacademy.stage9.ex3;

@TestSuite({"m1", "m2"})
public class Test {
    public void m1(){
        System.out.println("m1");
    }
    public void m2(){
        System.out.println("m2");
    }
    public void m3(){

    }

    public static void main(String[] args)
    {
        TestSuitHandler.run(Test.class);
    }
}
