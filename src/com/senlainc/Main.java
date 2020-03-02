package com.senlainc;

import com.senlainc.task1.Task1;
import com.senlainc.task2.Task2;
import com.senlainc.task3.Task3;
import com.senlainc.task4.Task4;
import com.senlainc.task5.Task5;
import com.senlainc.task6.Task6;

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
            "e. exit\n\n";
    private static final String toEXIT = "e to exit, q to quit";
    private static final String TASK1 = "task1 - even or odd, prime or composite number";
    private static final String TASK2 = "task2 - lcm and gcd numbers";
    private static final String TASK3 = "task3\n" +
            "count number of words in a sentence\n" +
            "display words in sorted form\n" +
            "uppercase first letter of each word";
    private static final String TASK4 = "task4 - number of matches in the text";
    private static final String TASK5 = "task5 - find palindromes";
    private static final String TASK6 = "task6 - knapsack task";

    private static String[] input;

    private Main() {
        super();
    }

    public static void main(String[] args) {
        clear();
        do {
            switch (menu()) {
                case 1:
                    System.out.print(toEXIT + "\n" + TASK1);
                    while (input("enter an integer")) {
                        Task1.print(Integer.parseInt(input[0]));
                    }
                    break;
                case 2:
                    System.out.print(toEXIT + "\n" + TASK2);
                    while (input(new String[]{"a = ", "b = "})) {
                        Task2.print(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
                    }
                    break;
                case 3:
                    System.out.print(toEXIT + "\n" + TASK3);
                    while (input(1, "enter a sentence")) {
                        Task3.print(input[0]);
                    }
                    break;
                case 4:
                    System.out.print(toEXIT + "\n" + TASK4);
                    while (input(2, "enter text and word")) {
                        input[1] = input[1].split(Task3.regex)[0];
                        Task4.print(input[0], input[1]);
                    }
                    break;
                case 5:
                    System.out.print(toEXIT + "\n" + TASK5);
                    while (input("enter an integer (0 - 100)")) {
                        int number = Integer.parseInt(input[0]);
                        if (0 > number || number > 100) {
                            retry();
                            continue;
                        }
                        Task5.print(number);
                    }
                    break;
                case 6:
                    System.out.print(toEXIT + "\n" + TASK6);
                    while (input()) {
                        clear();
                        System.out.print(toEXIT + "\n" + TASK6 + "\n\n");
                        (new Task6()).print();
                    }
                    break;
                default:
                    return;
            }
        } while (true);
    }

    private static int menu() {
        do {
            System.out.print(MENU);
            System.out.print("> ");
            String input;
            input = new Scanner(System.in).nextLine();
            if (input.equals("exit") || input.equals("e") ||
                    input.equals("quit") || input.equals("q")) {
                clear();
                System.exit(0);
            }
            int menu;
            try {
                menu = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                clear();
                continue;
            }
            if (1 > menu || menu > 6) {
                clear();
                continue;
            }
            clear();
            return menu;
        } while (true);
    }

    private static boolean input(int count, String text, String[] pattern, boolean integer) {
        System.out.print("\n\n" + text + "\n\n");
        input = new String[count];
        int i = 0;
        while (i < count) {
            System.out.print("> " + pattern[i]);
            input[i] = new Scanner(System.in).nextLine();
            if (input[i].equals("exit") || input[i].equals("e")) {
                clear();
                System.exit(0);
            }
            if (input[i].equals("quit") || input[i].equals("q")) {
                clear();
                return false;
            }
            if (integer) {
                try {
                    Integer.parseInt(input[i]);
                } catch (NumberFormatException e) {
                    retry();
                    continue;
                }
            }
            ++i;
        }
        return true;
    }

    private static boolean input(int count, String text) {
        String[] strings = new String[count];
        for (int i = 0; i < count; ++i) {
            strings[i] = "";
        }
        return input(count, text, strings, false);
    }

    private static boolean input(String[] strings) {
        return input(2, "enter integers (a, b)", strings, true);
    }

    private static boolean input(String text) {
        return input(1, text, new String[]{""}, true);
    }

    private static boolean input() {
        return input(1, "press enter", new String[]{""}, false);
    }

    private static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void retry() {
        System.out.print(String.format("error, try again! (%s)\n\n", toEXIT));
    }
}
