package ua.khpi.oop.kulyk04;

import java.util.Scanner;

public class Text {
    private String text;
    private StringBuilder editText;

    Text() {
        System.out.println("Enter text:");
        Scanner in = new Scanner(System.in);
        this.text = in.nextLine();
    }

    void setText() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text:");
        this.text = in.nextLine();

    }

    void editText() {
       editText = UtilitarianClass.changeText(text);
    }

    void getText() {
        System.out.println(text);
    }

    void getEditText() {
        System.out.println(editText);
    }
}
