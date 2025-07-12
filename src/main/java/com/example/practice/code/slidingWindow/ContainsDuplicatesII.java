package com.example.practice.code.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k, otherwise return false.
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * Input: nums = [2,1,2], k = 1
 * Output: false
 */
public class ContainsDuplicatesII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> window = new HashSet<>();

        int i = 0;
        int j = 0;

        while(j<nums.length){
            if(j-i>k){
                window.remove(nums[i]);
                i++;
            }

            if(window.contains(nums[j])){
                return true;
            }else{
                window.add(nums[j]);
                j++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ContainsDuplicatesII obj = new ContainsDuplicatesII();

        int[] input1 = {1,2,3,1}; int k1 = 3;
        int[] input2 = {2,1,2}; int k2 = 1;

        System.out.println(obj.containsNearbyDuplicate(input1,k1));

        System.out.println(obj.containsNearbyDuplicate(input2,k2));

    }

}
