package com.example.practice.code.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Replace elements by its rank in the array
 * Problem Statement: Given an array of N integers, the task is to replace each element of the array by its rank in the array.
 * Examples:
 * Example 1:
 * Input: 20 15 26 2 98 6
 * Output: 4 3 5 1 6 2
 * Explanation: When sorted,the array is 2,6,15,20,26,98. So the rank of 2 is 1,rank of 6 is 2,rank of 15 is 3 and so…
 * Example 2:
 * Input: 1 5 8 15 8 25 9
 * Output: 1 2 3 5 3 6 4
 * Explanation: When sorted,the array is 1,5,8,8,9,15,25. So the rank of 1 is 1,rank of 5 is 2,rank of 8 is 3 and so…
 */
public class ReplaceEachElementWithItsRank {


    public int[] solution(int[] ar){

        int[] result = new int[ar.length];

        int[] dummyAr = new int[ar.length];
        System.arraycopy(ar,0,dummyAr,0,ar.length);

        Arrays.sort(dummyAr);

        int temp = 1;
        Map<Integer,Integer> rankMap = new HashMap<>();

        for(int i:dummyAr){
            if(!rankMap.containsKey(i)){
                rankMap.put(i,temp);
                temp++;
            }
        }

        int k = 0;
        for(int i:ar){
            result[k] = rankMap.get(i);
            k++;
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int [] i = {20,15,26,2,98,6};

        ReplaceEachElementWithItsRank obj = new ReplaceEachElementWithItsRank();
        obj.solution(i);
    }

}
