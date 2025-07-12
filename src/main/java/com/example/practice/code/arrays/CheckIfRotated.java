package com.example.practice.code.arrays;

/**
 * Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
 * There may be duplicates in the original array.
 * Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: true
 * Explanation: [1,2,3,4,5] is the original sorted array.
 * You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
 * Example 2:
 * Input: nums = [2,1,3,4]
 * Output: false
 * Explanation: There is no sorted array once rotated that can make nums.
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: true
 * Explanation: [1,2,3] is the original sorted array.
 * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 *
 * Brute Force : Copy original array to another array and sort the copied array
 * now start with i=1, rotate array by 1 then 2... at each step check whether the rotated array is equal to original given array
 *
 * Optimal solution below
 */
public class CheckIfRotated {

    public boolean check(int[] a) {

        int pivot = -1;
        int n = a.length;

        if(n==1){
            return true;
        }

        for(int i=0;i<n-1;i++){

            if(a[i]>a[i+1]){
                pivot = i;
            }
        }

        if(pivot==-1){
            return true;
        }

        int i=(pivot+1)%n;

        boolean sorted = true;

        while(sorted && i!=pivot){
            if(a[i]<=a[(i+1)%n]){
                i = (i+1)%n;
            }else{
                sorted = false;
            }
        }

        return sorted;

    }

    public static void main(String[] args) {
        CheckIfRotated obj = new CheckIfRotated();
        int[] a = {3,4,5,1,2};
        int[] a1 = {1,3,2};

        System.out.println(obj.check(a));

        System.out.println(obj.check(a1));

    }

}
