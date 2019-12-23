package ua.khpi.oop.kulyk03;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = in.nextLine();
        in.close();

       UtilitarianClass.change5text(text);

    }



}