package com.example.practice.code.slidingWindow;


/**
 * Important
 * https://www.youtube.com/watch?v=XnMdNUkX6VM
 * Array containing 0, 1. We need to find all contiguous subarrays whose sum = goal.
 *
 * Brute force - calculate all subarrys and check
 * Optimal - we find all subarrays who sum <= goal and substract count of subarrays whose sum <= goal -1
 */
public class BinarySubarraysWithSum {

    public int solution(int[] nums, int goal){

        if(goal<0) return 0;

        int count = 0;

        int l = 0;
        int r = 0;

        int sum = 0;

        while(r<nums.length){
            sum+=nums[r];

            while (sum>goal){
                sum-=nums[l];
                l++;
            }

            count = count + (r-l+1);
            r++;
        }

        return count;

    }

    public static void main(String[] args) {
        int[] input = {1,1,0,1,1};
        int goal = 3;

        BinarySubarraysWithSum obj = new BinarySubarraysWithSum();

        System.out.println("Result:"+(obj.solution(input,goal)-obj.solution(input,goal-1)));

    }

}
