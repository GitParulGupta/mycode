package com.example.practice.code.arrays;

public class MaximumSubArraySumOfSizeK {

    public int maxSubArrayK(int[] nums, int k) {

        if(nums.length<k){
            return 0;
        }

        int windowSum = 0; //initialise window sum

        for(int i=0;i<k;i++){
            windowSum+=nums[i];
        }

        int maxSum = windowSum;

        for(int i=k;i<nums.length;i++){
            windowSum += nums[i]-nums[i-k];
            maxSum = Math.max(maxSum,windowSum);
        }

        return maxSum;
    }

}
