package ua.khpi.oop.kulyk04;

import java.util.Scanner;
/*      Використовуючи програму рiшення завдання лабораторної роботи №3, вiдповiдно до прикладної
        задачi забезпечити обробку команд користувача у виглядi текстового меню:
            введення даних;
            перегляд даних;
            виконання обчислень;
            вiдображення результату;
            завершення програми i т.д.
        Забезпечити обробку параметрiв командного рядка для визначення режиму роботи програми:
            параметр “-h” чи “-help”:
                   вiдображається iнформацiя про автора програми, призначення (iндивiдуальне завдання),
                   детальний опис режимiв роботи (пунктiв меню та параметрiв командного рядка);
            параметр “-d” чи “-debug”:
                   в процесi роботи програми вiдображаються додатковi данi,
                   що полегшують налагодження та перевiрку працездатностi програми:
                            дiагностичнi повiдомлення, промiжнi значення змiнних,
                            значення тимчасових змiнних та iн.
* */

public class Main {

    public static void main(String[] args) {

        if (args.length == 1) {
            if (args[0].equals("-h") || args[0].equals("-help")) {
                UtilitarianClass.info();
            }
        } else if (args.length == 2) {
            if (args[0].equals("-h") || args[0].equals("-help") || args[1].equals("-h") || args[1].equals("-help")) {
                UtilitarianClass.info();
            }
        }
        Text result = new Text();
        int i = 0;
        Scanner in = new Scanner(System.in);


        do {
            if (args.length == 1) {
                if (args[0].equals("-d") || args[0].equals("-debug")) {
                    System.out.print("Text:");
                    result.getText();

                    System.out.print("Edited text:");
                    result.getEditText();

                }
            } else if (args.length == 2) {
                if (args[0].equals("-d") || args[0].equals("-debug") || args[1].equals("-d") || args[1].equals("-debug")) {
                    System.out.print("Text:");
                    result.getText();

                    System.out.print("Edited text:");
                    result.getEditText();

                }
            }

            System.out.println(
                    "\n_______________________________________________\n" +
                            "Menu:\n" +
                            "1.Change current text\n" +
                            "2.Check current text\n" +
                            "3.Processing current text\n" +
                            "4.Check result\n" +
                            "5.Exit program");
            System.out.println("\nSelect option:");


            i = in.nextInt();

            if (i > 0 && i < 6) {
                switch (i) {
                    case 1:
                        result.setText();
                        break;
                    case 2:
                        result.getText();
                        break;
                    case 3:
                        result.editText();
                        break;
                    case 4:
                        result.getText();
                        result.getEditText();
                        break;
                    case 5:
                        i = 5;
                }
                System.out.println("_______________________________________________\n\n");
            } else {
                System.out.println("You entered an incorrect value");
            }
        } while (i != 5);
        in.close();
    }
}
