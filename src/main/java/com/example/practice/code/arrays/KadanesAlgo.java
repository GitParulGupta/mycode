package com.example.practice.code.arrays;

import java.util.Arrays;

/**
 * Keep on adding sum and at each step generate the maximum sum. if at any point sum <0, then sum = 0
 *
 * This is useful for problems like Maximum Subarray sum
 * Brute Force: generate all sub arrays and find sum
 * Optimal: Kadane's algo
 */
public class KadanesAlgo {

    //Note that this solution fails for all-negatives array
    public long maximumSubarraySum(int[] a){
        long sum = 0;
        long max = Long.MIN_VALUE;

        int i =0;

        while(i<a.length){
            sum = sum + a[i];

            if(sum<0){
                sum = 0;
            }
            if(sum>max){
                max = sum;
            }
            i++;
        }

        return max;
    }

    public long maximumSubarraySumBest(int[] nums){

        int curSum = nums[0];
        int maxSum = nums[0];

        for(int i=1;i<nums.length;i++){
            curSum = Math.max(nums[i],nums[i]+curSum);
            maxSum = Math.max(maxSum,curSum);
        }
        return maxSum;
    }

    //Note that this solution fails for all-negatives array
    public void printMaximumSubarraySum(int[] a){
        long sum = 0;
        long max = Long.MIN_VALUE;

        int i =0;
        int start = -1;
        int maxS = -1;
        int maxE = -1;

        while(i<a.length){
            if(sum==0){
                start = i;
            }
            sum = sum + a[i];
            if(sum>max){
                max = sum;
                maxS = start;
                maxE = i;
            }
            if(sum<0){
                sum = 0;
            }
            i++;
        }

        if(maxS>-1) {
            for (int x=maxS;x<=maxE;x++){
                System.out.print(a[x]);
                System.out.print("  ");
            }
        }
    }


    public int[] printMaximumSubarraySumBest(int[] nums) {

        int maxSum = nums[0];
        int currSum = nums[0];
        int maxStart = 0, maxEnd = 0;
        int currStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currSum + nums[i]) {
                currStart = i;  // Start new subarray
            }
            currSum = Math.max(nums[i], currSum + nums[i]);

            if (currSum > maxSum) {
                maxSum = currSum;
                maxStart = currStart;
                maxEnd = i;
            }
        }

        // Print subarray
        System.out.print("Max subarray: [");
        for (int j = maxStart; j <= maxEnd; j++) {
            System.out.print(nums[j]);
            if (j < maxEnd) System.out.print(", ");
        }
        System.out.println("] with sum: " + maxSum);

        return new int[]{maxStart, maxEnd, maxSum};
    }



    public static void main(String[] args) {
        int[] a = {-2,-3,4,-1,-2,1,5,-3};
        KadanesAlgo obj = new KadanesAlgo();
        System.out.println(obj.maximumSubarraySum(a));
        obj.printMaximumSubarraySum(a);
    }

}
