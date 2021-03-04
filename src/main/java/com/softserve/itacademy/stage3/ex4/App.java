package com.softserve.itacademy.stage3.ex4;

public class App {

    public static String drawLine(LineType lineType) {
        System.out.printf("The line is %s type", lineType.toString().toLowerCase());
        return "";
    }

    public static void main(String[] args)
    {
        App.drawLine(LineType.DASHED);
        System.out.println();
        App.drawLine(LineType.DOUBLE);
        System.out.println();
        App.drawLine(LineType.DOTTED);
        System.out.println();
        App.drawLine(LineType.SOLID);
    }

}
