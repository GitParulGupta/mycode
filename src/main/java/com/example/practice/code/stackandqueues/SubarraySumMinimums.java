package com.example.practice.code.stackandqueues;

import java.util.Arrays;

/**
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
 * Example 1:
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation:
 * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Sum is 17.
 * Example 2:
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 */
public class SubarraySumMinimums {

    //Solution1: Print all contiguous sub arrays and find minimum in each sub array to find the sum

    //O(n^2)
    public int solution1(int[] a){
        int sum = 0;
        int mod = (int)(1e9+7);

        for(int i=0;i<a.length;i++){
            int min =  a[i];
            for(int j=i;j<a.length;j++){
                min = Math.min(a[j],min);
                sum+=min%mod;
            }
        }

        return sum;
    }

    //Solution 2: By finding contribution of each element

    public int solution2(int[] a){
        int sum = 0;
        int mod = (int)(1e9+7);

        NextSmallerElement obj = new NextSmallerElement();
        int[] nse = obj.solution(a);

        PreviousSmallerElement obj2 = new PreviousSmallerElement();
        int[] pse = obj.solution(a);

        for(int i=0;i<a.length;i++){
            int left = i-pse[2];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {3,1,2,4};

        SubarraySumMinimums obj = new SubarraySumMinimums();

        System.out.println("For array: "+ Arrays.toString(a)+" solution from brute force approach: "+obj.solution1(a));
    }
}
