package com.example.practice.code.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Find the longest sub-array of sum K.
 * TC: O(2N)
 */
public class LongestSubarraySumPositivesNegatives {

    public int solution(int[] a, int k){

        int sum = 0; int length = 0;
        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();
        int i = 0;
        while(i<a.length){
            sum = sum + a[i];

            if(sum==k){
                length = Math.max(length,i+1);
            }

            int remSum = sum - k;

            if(prefixSumMap.containsKey(remSum)){
                int remSumIndex = prefixSumMap.get(remSum);
                length = Math.max(length,i-remSumIndex);
            }

            if(!prefixSumMap.containsKey(sum)){
                prefixSumMap.put(sum,i);
            }
            i++;
        }

        return length;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,1,1,1,1,1,3,3};
        int k1 = 3;
        int k11 =5;
        int k111 = 20;

        int[] a2 = {-3, 2, 1};
        int k2 = 6;
        int k22 = 3;

        int[] a3 = {2,0,0,3};
        int k3 = 3;


        LongestSubarraySumPositivesNegatives obj = new LongestSubarraySumPositivesNegatives();
        System.out.println("Input:"+Arrays.toString(a1)+" k:"+k1+" "+obj.solution(a1,k1));
        System.out.println("\n");
        System.out.println("Input:"+Arrays.toString(a2)+" k:"+k2+" "+obj.solution(a2,k2));
        System.out.println("Input:"+Arrays.toString(a2)+" k:"+k22+" "+obj.solution(a2,k22));
        System.out.println("\n");
        System.out.println("Input:"+Arrays.toString(a3)+" k:"+k3+" "+obj.solution(a3,k3));
    }

}
