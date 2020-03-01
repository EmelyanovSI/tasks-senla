package com.senlainc.task3;

import java.util.Arrays;

public class Task3 {

    public static int count(String string) {
        return string.split(" +").length;
    }

    public static String[] sort(String string) {
        String[] words = string.split("[ :;,.!?()\"']+");
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words.length - 1 - i; ++j) {
                if (words[j].length() > words[j + 1].length()) {
                    String str = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = str;
                }
            }
        }
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
