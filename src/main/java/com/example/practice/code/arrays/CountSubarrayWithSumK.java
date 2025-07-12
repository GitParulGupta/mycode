package com.example.practice.code.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array which contains negatives, we want to fetch the number of sum arrays whose elements sum up to k(given)
 * Brute force: generate all sub arrays and check for solution
 * Optimal solution: using presum approach - this states that until a given index i, if we generate preSum and we are looking for elements which generate sum k, we might also have elements whose sum= presum-k which might also give us k.
 */
public class CountSubarrayWithSumK {

    public int solution(int[] a, int k){
        Map<Integer,Integer> m = new HashMap<>();
        int preSum = 0;
        int count = 0;
        m.put(0,1);//start of array

        for(int i=0;i<a.length;i++){
            preSum+=a[i];
            int remove = preSum-k;
            count+= m.getOrDefault(remove,0);
            m.put(preSum, m.getOrDefault(preSum,0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        CountSubarrayWithSumK obj = new CountSubarrayWithSumK();

        System.out.println(obj.solution(a,k));
    }

}
