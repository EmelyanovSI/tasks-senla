package com.senlainc;

import com.senlainc.task1.Task1;
import com.senlainc.task2.Task2;
import com.senlainc.task3.Task3;
import com.senlainc.task4.Task4;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String MENU = "tasks-senla\n" +
            "1. task1\n" +
            "2. task2\n" +
            "3. task3\n" +
            "4. task4\n" +
            "5. task5\n" +
            "6. task6\n" +
            "0. exit\n";
    private static final String toEXIT = "0 to exit";
    private static final String TASK1 = "task1 - even or odd, prime or composite number";
    private static final String TASK2 = "task2 - lcm and gcd numbers";
    private static final String TASK3 = "task3\n" +
            "count number of words in a sentence\n" +
            "display words in sorted form\n" +
            "uppercase first letter of each word";
    private static final String TASK4 = "number of matches in the text";
    private static final String TASK5 = "";
    private static final String TASK6 = "";

    private Main() {
        super();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        do {
            clear();
            System.out.println(MENU);
            input();
            int menu;
            try {
                menu = Integer.parseInt(new Scanner(System.in).next());
            } catch (NumberFormatException e) {
                continue;
            }
            if (0 > menu || menu > 6) {
                continue;
            }
            clear();
            switch (menu) {
                case 0:
                    clear();
                    return;
                case 1:
                    System.out.println(toEXIT);
                    System.out.println(TASK1);
                    do {
                        System.out.println();
                        System.out.println("enter an integer");
                        System.out.println();
                        input();
                        int number;
                        try {
                            number = Integer.parseInt(new Scanner(System.in).next());
                        } catch (NumberFormatException e) {
                            retry();
                            continue;
                        }
                        if (number == 0) {
                            break;
                        }
                        Task1.print(number);
                    } while (true);
                    break;
                case 2:
                    System.out.println(toEXIT);
                    System.out.println(TASK2);
                    do {
                        System.out.println();
                        System.out.println("enter integers (a, b)");
                        System.out.println();
                        input();
                        System.out.print("a = ");
                        int a, b;
                        try {
                            a = Integer.parseInt(new Scanner(System.in).next());
                        } catch (NumberFormatException e) {
                            retry();
                            continue;
                        }
                        if (a == 0) {
                            break;
                        }
                        input();
                        System.out.print("b = ");
                        try {
                            b = Integer.parseInt(new Scanner(System.in).next());
                        } catch (NumberFormatException e) {
                            retry();
                            continue;
                        }
                        if (b == 0) {
                            break;
                        }
                        Task2.print(a, b);
                    } while (true);
                    break;
                case 3:
                    System.out.println(toEXIT);
                    System.out.println(TASK3);
                    do {
                        System.out.println();
                        System.out.println("enter a sentence");
                        System.out.println();
                        input();
                        String string;
                        try {
                            string = new Scanner(System.in).nextLine();
                        } catch (NumberFormatException e) {
                            retry();
                            continue;
                        }
                        if (string.equals("0")) {
                            break;
                        }
                        Task3.print(string);
                    } while (true);
                    break;
                case 4:
                    System.out.println(toEXIT);
                    System.out.println(TASK4);
                    do {
                        System.out.println();
                        System.out.println("enter text and word");
                        System.out.println();
                        input();
                        String string, word;
                        try {
                            string = new Scanner(System.in).nextLine();
                        } catch (NumberFormatException e) {
                            retry();
                            continue;
                        }
                        if (string.equals("0")) {
                            break;
                        }
                        input();
                        try {
                            word = new Scanner(System.in).nextLine();
                        } catch (NumberFormatException e) {
                            retry();
                            continue;
                        }
                        if (word.equals("0")) {
                            break;
                        }
                        Task4.print(string, word);
                    } while (true);
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (true);
    }

    private static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    private static void input() {
        System.out.print("> ");
    }

    private static void retry() {
        System.out.println("error, try again! (0 to exit)");
    }
}
