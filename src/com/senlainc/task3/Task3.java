package com.senlainc.task3;

import java.util.Arrays;

public class Task3 {

    public static String regex = "[ :;,.!?()\"']+";

    public static int count(String string) {
        return string.split(regex).length;
    }

    public static String[] sort(String string) {
        String[] words = string.split(regex);
        Arrays.sort(words);
        return words;
    }

    public static String uppercase(String string) {
        StringBuilder builder = new StringBuilder(string);
        if (Character.isAlphabetic(string.codePointAt(0))) {
            builder.setCharAt(0, Character.toUpperCase(string.charAt(0)));
        }
        for (int i = 1; i < string.length(); ++i) {
            if (Character.isAlphabetic(string.charAt(i)) && Character.isSpaceChar(string.charAt(i - 1))) {
                builder.setCharAt(i, Character.toUpperCase(string.charAt(i)));
            }
        }
        return builder.toString();
    }

    public static void print(String string) {
        System.out.println(uppercase(string));
        System.out.println(count(string) + " words in a sentence");
        System.out.println(Arrays.toString(sort(string)));
    }

}
