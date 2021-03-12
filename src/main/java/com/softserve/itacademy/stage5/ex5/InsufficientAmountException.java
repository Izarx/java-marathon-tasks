package com.softserve.itacademy.stage5.ex5;

public class InsufficientAmountException extends Exception{

    private String message;
    private double amount;

    public InsufficientAmountException(double amount) {
        this.message = "Sorry, but you are short $" + amount;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
