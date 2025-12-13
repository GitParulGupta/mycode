package com.example.practice.code.maths;

/**
 * You are given a number ‘N’ and a query ‘Q.’ If ‘Q’ is 1, then you have to return the sum of all integers from 1 to ‘N,’ else if ‘Q’ is equal to 2 then you have to return the product of all integers from 1 to ‘N.’ Since the product can be very large, return it modulo 10 ^ 9 + 7.
 * For example
 * Given ‘N’ = 4, ‘Q’ = 1.
 * Then the answer is 10 because the sum of all integers between 1 and 4 are 1, 2, 3, and 4. Hence 1 + 2 + 3 + 4 is equal to 10.
 */
public class SumOrProduct {

    public long sumOrProduct(int n, int q) {

        long result = 0;

        if (q == 1) {

            return (n * (n + 1) / 2) % (10 ^ 9 + 7);

        } else {

            result = 1;

            for (int i = 1; i <= n; i++) {
                if (Math.multiplyExact(result,i) > (10 ^ 9 + 7)) {
                    result = Math.multiplyExact(result,i) % (10 ^ 9 + 7);
                } else {
                    result = Math.multiplyExact(result,i);
                }
            }

            return result;

        }
    }

    public static void main(String[] args) {
        int n =5; int q = 2;

        SumOrProduct obj = new SumOrProduct();
        System.out.println(obj.sumOrProduct(n,q));
    }
}