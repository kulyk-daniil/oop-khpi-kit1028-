package ua.khpi.oop.kulyk02;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            double x = Math.random() * 100;
            int a = (int) x;
            x = Math.random() * 100;
            int b = (int) x;
            int res = gcd(a, b);
            System.out.println("a = " + a + "\tb = " + b + "\tGreatest common factor: " + res);
        }


    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

}
