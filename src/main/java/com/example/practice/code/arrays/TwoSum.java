package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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


    public int[] twoSumBest(int[] nums, int target) {

        int[] sortedNums = new int[nums.length];

        System.arraycopy(nums, 0, sortedNums, 0, nums.length);

        Arrays.sort(sortedNums);

        int left = 0;
        int right = sortedNums.length-1;

        while(left<right){
            if(sortedNums[left]+sortedNums[right]==target){
                break;
            }else if(sortedNums[left]+sortedNums[right]<target){
                left++;
            }else{
                right--;
            }
        }

        int[] result = {-1,-1};

        for(int i=0;i<nums.length;i++){
            if(nums[i]==sortedNums[left]){
                result[0] = i;
                break;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]==sortedNums[right] && i!=result[0]){
                result[1] = i;
                break;
            }
        }
        return result;

    }

/*
    public static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {

        ArrayList<Pair<Integer, Integer>> l = new ArrayList<>();

        Collections.sort(arr);

        int i=0;
        int j=n-1;

        while(i<n && j>=0 && i<j){
            int sum = arr.get(i)+arr.get(j);

            if(sum==target){
                l.add(new Pair(arr.get(i),arr.get(j)));
                i++;
                j--;
            }else if(sum<target){
                i++;
            }else{
                j--;
            }
        }

        return l;
    }*/

}
