package com.senlainc.task1;

import java.math.BigInteger;

public class Task1 {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        return number > 1 && BigInteger.valueOf(number).isProbablePrime((int) Math.log(number));
    }

    public static void print(int number) {
        System.out.println(String.format(
                number + " is %s and %s number",
                isEven(number) ? "even" : "odd",
                isPrime(number) ? "prime" : "composite"
        ));
    }

}
