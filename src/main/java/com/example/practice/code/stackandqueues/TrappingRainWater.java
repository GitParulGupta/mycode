package com.example.practice.code.stackandqueues;


import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class TrappingRainWater {

    //Water gets trapped ebtween left max and right maximum
    public int solution1(int[] nums){

        int[] prefixMax = new int[nums.length];

        prefixMax[0] = nums[0];

        for(int i=1;i<nums.length;i++){

            prefixMax[i] = Math.max(prefixMax[i-1],nums[i]);

        }

        int[] suffixMax = new int[nums.length];

        suffixMax[nums.length-1] = nums[nums.length-1];

        for(int i=nums.length-2;i>=0;i--){

            suffixMax[i] = Math.max(suffixMax[i+1],nums[i]);

        }

        int water = 0;

        for(int i=0;i<nums.length;i++){
            water+=Math.min(prefixMax[i],suffixMax[i])-nums[i];
        }

        return water;

    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        TrappingRainWater obj = new TrappingRainWater();
        System.out.println("Solution for array "+ Arrays.toString(height)+" -> "+obj.solution1(height));

        int[] height2 = {4,2,0,3,2,5};
        System.out.println("Solution for array "+ Arrays.toString(height2)+" -> "+obj.solution1(height2));
    }
}
