package com.example.practice.code.arrays;

import java.util.*;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * Notice that |val| denotes the absolute value of val.
 * Example 1:
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 */
public class FindPairsWithDiffKUnique {

    public static int getPairsWithDifferenceK(int arr[], int k) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            indexMap.put(arr[i],indexMap.getOrDefault(arr[i],0)+1);
        }

        int pair = 0;

        for(Map.Entry<Integer,Integer> e: indexMap.entrySet()){

            if(k==0 && e.getValue()>1){
                pair+=1;
            }else{
                int key = e.getKey();
                int offset = key+k;
                if(indexMap.containsKey(offset) && key!=offset){
                    pair+=1;
                }
            }
        }

        return pair;
    }

    public static void main(String[] args) {
        int[] ar1 = {3,1,4,1,5}; int k1 = 2;
        int[] ar2 = {1,2,3,4,5}; int k2 = 1;
        int[] ar3 = {1,3,1,5,4}; int k3 = 0;

        System.out.println(FindPairsWithDiffKUnique.getPairsWithDifferenceK(ar1,k1));
        System.out.println(FindPairsWithDiffKUnique.getPairsWithDifferenceK(ar2,k2));
        System.out.println(FindPairsWithDiffKUnique.getPairsWithDifferenceK(ar3,k3));
    }

}
