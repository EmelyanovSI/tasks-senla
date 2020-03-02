package com.senlainc.task5;

import java.util.ArrayList;

public class Task5 {

    public static boolean isPalindrome(String string) {
        return string.equals(new StringBuilder().append(string).reverse().toString());
    }

    public static ArrayList<Integer> findPalindromes(int number) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < number; ++i) {
            if (isPalindrome(String.valueOf(i))) {
                array.add(i);
            }
        }
        return array;
    }

    public static void print(int number) {
        System.out.println("All palindromes:\n" + findPalindromes(number));
    }

}
