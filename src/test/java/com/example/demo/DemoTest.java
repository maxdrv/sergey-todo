package com.example.demo;

import java.io.File;
import java.io.Writer;

public class DemoTest {
    public static void main(String[] args) {
        File file = new File("text.txt");
        String str = "Serega";
        String hjhgj = "ghuglgghjg";
        System.out.println(hjhgj);
        DemoTest demoTest = new DemoTest();
        demoTest.sum(5,6);
        sum1(4,5);
        sum1(4,1);
        demoTest.sum(3,5);
        System.out.println(Math.pow(5,6));
        int x = 0;
        while (x<5){
            System.out.println("1 ");
            x++;
        }
        for (int i = 0; i <5; i++) {
            System.out.println("ggffdhd");

        }
    }


    public int sum(int a, int b){
        System.out.println(a+b);
        return a+b;
    }
    public static int sum1(int a, int b){
        System.out.println(a+b);
        return a+b;
    }


}
