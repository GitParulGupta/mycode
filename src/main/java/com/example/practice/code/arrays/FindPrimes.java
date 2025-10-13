package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * SieveOfEratosthenes
 *
 * You are given a positive integer ‘N’. Your task is to print all prime numbers less than or equal to N.
 * Note: A prime number is a natural number that is divisible only by 1 and itself. Example - 2, 3, 17, etc.
 * You can assume that the value of N will always be greater than 1. So, the answer will always exist.
 * Detailed explanation ( Input/output format, Notes, Images )
 * Constraints:
 * 2 <= N <= 10^7
 * Where ‘N’ is the given positive integer.
 * Time Limit: 1sec
 *
 */
public class FindPrimes {
    public static ArrayList<Integer> primeNumbersTillN(int N) {

        boolean[] table = new boolean[N+1];
        Arrays.fill(table,true);

        for(int i=2;i*i<N+1;i++){
            for(int j=i;j*i<N+1;j++){
                if(table[i])
                    table[i*j]=false;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=2;i<table.length;i++){
            if(table[i])result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;

        ArrayList<Integer> result = FindPrimes.primeNumbersTillN(n);
        result.stream().forEach(System.out::println);
    }
}
