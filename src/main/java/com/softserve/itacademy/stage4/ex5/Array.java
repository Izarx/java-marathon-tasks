package com.softserve.itacademy.stage4.ex5;

public class Array<T> {
    private T[] array;

    public Array(final T[] array)
    {
        this.array = array;
    }

    public T get(int index)
    {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}
