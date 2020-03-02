package com.senlainc.task4;

import com.senlainc.task3.Task3;

public class Task4 {

    public static int count(String string, String word) {
        int number = 0;
        String[] words = string.split(Task3.regex);
        word = word.toLowerCase();
        for (String w : words) {
            if (word.equals(w.toLowerCase())) {
                ++number;
            }
        }
        return number;
    }

    public static void print(String string, String word) {
        System.out.println(count(string, word) + " matches found");
    }

}
