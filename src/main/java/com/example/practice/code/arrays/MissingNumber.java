package com.example.practice.code.arrays;

/**
 * Given an array a = {1,2,4,5} which consists of number 1 to n, Given n = 5. Find the missing number.
 * Hashing -> Take a hashing array initialise all elements as 0, for every element in array a, mark index found.
 * O(n) and space complexity is O(n)
 * Optimal approach
 * 1. sum of n numbers method
 * 2. xor method - if 2 numbers appear twice, the xor will be returned as 0
 */
public class MissingNumber {

    public int findMissingUsingSum(int[] a, int n){

        int sum = 0;

        for(int i:a){
            sum+=i;
        }

        int sumExpected =  n*(n+1)/2;

        return sumExpected - sum;

    }

    public int findMissingUsingXor(int[] a, int n){

        int xor1 = 1;

        for(int i:a){
            xor1=xor1^i;
        }

        int xor2 = 1;
        for(int i=1;i<=n;i++){
            xor2=xor2^i;
        }

        return xor2^xor1;

    }

    public static void main(String[] args) {
        int[] a = {1,2,4,5};
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.findMissingUsingSum(a,5));
        System.out.println(obj.findMissingUsingXor(a,5));
    }
}
