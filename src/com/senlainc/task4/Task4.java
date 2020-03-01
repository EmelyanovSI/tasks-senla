package com.senlainc.task4;

public class Task4 {

    public static int count(String string, String word) {
        int number = 0;
        String[] words = string.split("[ :;,.!?()\"']+");
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
