package ua.khpi.oop.kulyk08;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	System.setProperty("console.encoding","Cp866");
	Menu menu = new Menu();
	menu.showMenu();
    }

}
