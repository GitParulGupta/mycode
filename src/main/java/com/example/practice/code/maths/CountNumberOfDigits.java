package com.example.practice.code.maths;

import static java.lang.Math.log10;

/**
 * Given integer number N, find number of digits in the number
 */
public class CountNumberOfDigits {

    public int solution(int n){

        int result = 0;

        while(n>0){
            result++;
            n=n/10;
        }
        return result;
    }

    /**
     * The logarithmic base 10 of a positive integers gives the number of digits in n.
     * We add 1 to the result to ensure that the count is correct even for numbers that are powers of 10.
     * @param n
     * @return
     */
    public int optimalSolution(int n){
        return (int)(log10(n)+1);
    }

    public static void main(String[] args) {
        int n = 12345;
        CountNumberOfDigits obj = new CountNumberOfDigits();
        System.out.println(obj.solution(n));
        System.out.println(obj.optimalSolution(n));
    }

}
