package com.example.practice.code.twopointer;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given a 0-indexed integer array nums of even length.
 *
 * As long as nums is not empty, you must repetitively:
 *
 * Find the minimum number in nums and remove it.
 * Find the maximum number in nums and remove it.
 * Calculate the average of the two removed numbers.
 * The average of two numbers a and b is (a + b) / 2.
 *
 * For example, the average of 2 and 3 is (2 + 3) / 2 = 2.5.
 * Return the number of distinct averages calculated using the above process.
 *
 * Note that when there is a tie for a minimum or maximum number, any can be removed.
 */
public class DistinctUniqueAvg {

    public int distinctAverages(int[] nums) {

        Set<Double> s = new HashSet<>();

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;

        while(left<right){
            double avg = (double) (nums[left] + nums[right]) /2;
            s.add(avg);
            left++;
            right--;
        }

        return s.size();
    }

}
