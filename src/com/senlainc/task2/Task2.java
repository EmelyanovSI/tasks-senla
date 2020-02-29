package com.senlainc.task2;

public class Task2 {

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void print(int a, int b) {
        System.out.println(String.format(
                "gcd(%d, %d) = %d\nlcm(%d, %d) = %d",
                a, b, gcd(a, b), a, b, lcm(a, b)
        ));
    }

}
