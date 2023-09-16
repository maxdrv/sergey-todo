package com.example.demo;

import java.util.Scanner;

public class KatinaXyiny {
    public static void main(String[] args) {
        long temp2 = 0;
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        if (x<0){
            x=Math.abs(x);
        }
        long q=x;
        int point = 0;
        while (q>0){
            q = q/10;
            point++;
        }
        long x2 =x;
        long i =0;
        while (i<point) {
            x=x2;
            long temp=x%10;
            long temp3 = x2/10;
            temp2=temp2+temp;
            x2=temp3;


            i++;
        }
        System.out.println(temp2);
    }


}



