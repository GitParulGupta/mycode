package com.example.practice.code.slidingWindow;

import java.util.Arrays;

/**
 * Example 1:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * This problem can be converted to longest subarray with atmost k zeros.
 */
public class MaxConsecutiveOnes {

    public int solution(int[] a, int k){
        int curZero = 0;
        int i = 0;
        int j = 0;

        int maxLen = 0;

        while(j<a.length){

            if(a[j]==0){
                curZero++;
            }
            while (curZero>k){
                if(a[i]==0){
                    curZero--;
                }
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] input1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;

        int[] input2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;

        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();

        System.out.println("Input Array:"+ Arrays.toString(input1)+" k: "+k1+" output: "+obj.solution(input1,k1));

        System.out.println("Input Array:"+ Arrays.toString(input2)+" k: "+k2+" output: "+obj.solution(input2,k2));

    }

}
