package com.example.practice.code.arrays;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * Brute force - double loop and check for target -> O(n^2)
 * better solution - hashing - store in hashmap -> O(nlogN) --> if we need to return the indices of 2 operands this is optimal
 * best --> 2 pointer (only in case we need to return yes or no if sum exists)
 *
 */
public class TwoSum {

    public int[] solution(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int complimentary = target - nums[i];

            if(map.containsKey(complimentary)){
                return new int[]{map.get(complimentary),i};
            }

            map.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

        TwoSum obj = new TwoSum();

        int[] nums = {2,7,11,15}; int target = 9;
        System.out.println(Arrays.toString(obj.solution(nums,target)));
        int[] nums1 = {3,3}; int target1 = 6;
        System.out.println(Arrays.toString(obj.solution(nums1,target1)));
    }

}
