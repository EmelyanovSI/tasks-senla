package com.senlainc;

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
    private static final String TASK1 = "";
    private static final String TASK2 = "";
    private static final String TASK3 = "";
    private static final String TASK4 = "";
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
