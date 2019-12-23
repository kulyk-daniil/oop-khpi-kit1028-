package ua.khpi.oop.kulyk04;

import java.util.Scanner;

public final class UtilitarianClass {

    public static StringBuilder changeText(String text) {
        System.out.print("Enter which word replace current:");
        Scanner in = new Scanner(System.in);
        String tmp = in.next();
        StringBuilder word = new StringBuilder(10);
        StringBuilder result = new StringBuilder(text.length());


        for (int i = 0, j = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                j = i;
                while (text.charAt(j) != ' ') {
                    word.append(text.charAt(j));
                    j++;
                }
                if (word.length() == tmp.length()) {
                    result.append(tmp + " ");
                    i = j;
                } else {
                    for (; i < j; i++) {
                        result.append(text.charAt(i));
                    }
                    result.append(" ");
                }
                word.delete(0, word.length());
            }

        }
        return result;
    }


    public static void info() {
        System.out.println("/**\n" +
                "* @file Main.java\n" +
                "* Lab 4\n" +
                "* File assignment    | Ввести текст. У текстi слова заданої довжини замiнити зазначеним рядком.\n\n" +
                "* @author            | Kulyk D.I.\n" +
                "* @version 1.0\n" +
                "* @date 2019.10.16\n" +
                "*/");
    }


}
