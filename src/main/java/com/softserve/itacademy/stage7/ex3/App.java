package com.softserve.itacademy.stage7.ex3;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public static void writeFile(String filename, String text) {

        // Write your code here
        char[] chars = text.toCharArray();
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filename)))
        {
            for(Character c : chars) {
                String ints = Integer.toBinaryString(c);
                while(ints.length() < 7) {
                    ints = "0" + ints;
                }
                dataOutputStream.writeBytes(ints);
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        writeFile("test.txt", "Hello!");
    }
}
