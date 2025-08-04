package com.example.practice.code.greedy;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * Constraints:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 * */
public class JumpGame2 {

    //aim is to minimise jumps
    //exponenetial TC -> o(N^N)
    //https://www.youtube.com/watch?v=7SBVnw7GSTk
    public int canJump(int[] nums) {
        int index = 0;
        int jumps = 0;
        return canJumpHelper(index, jumps, nums);
    }

    private int canJumpHelper(int index, int jumps, int[] nums){
        if(index>=nums.length-1){
            return jumps;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++) {
            min = Math.min(min, canJumpHelper(index+i,jumps+1,nums));
        }
        return min;
    }

    //optimal solution using DP

}
