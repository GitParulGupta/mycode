package com.example.practice.code.arrays;

import java.util.*;

/**
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *  Consecutive elements are those which are in increasing order by 1.
 *  Example: [100, 4, 200, 1, 3, 2] -> output is 4 (1, 2, 3, 4)
 *  Brute force: Double loop and check for each element if it is consecutive to the next element via linear search.
 *  TC: O(N^2) SC: O(1)
 *  Better Solution: Sort the array and then traverse it to find the longest consecutive sequence.
 *  TC: O(N log N) SC: O(1) for sorting
 *  Optimal Solution: Use a HashSet to store elements and check for consecutive elements in O(1) time.
 *  TC: O(N) SC: O(N)
 */
public class LongestConsecutiveSubsequence {

    public int betterSolution(int[] a){

        if(a.length==1){
            return a.length;
        }

        Arrays.sort(a);

        int maxLength = 0;
        int length = 1;

        int i=1;

        while(i<a.length){
            if(a[i]-a[i-1]==1){
                length++;
                maxLength = Math.max(length,maxLength);
                i++;
            }else if(a[i]-a[i-1]>1){
                length = 1;
            }
            i++;
        }
        return maxLength;
    }

    public int optimalSolution(int[] a){
        Set<Integer> elementSet = new HashSet<>();
        for (int i:a){
            elementSet.add(i);
        }

        Iterator<Integer> i = elementSet.iterator();
        int length = 1; int maxLength = 1;

        while (i.hasNext()){
            int element = i.next();
            if(!elementSet.contains(element-1)){
                while(elementSet.contains(element+1)){
                    element = element+1;
                    length++;
                    maxLength = Math.max(length,maxLength);
                }
            }
            length =1;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] a = {100,4,2,101,3,1};

        LongestConsecutiveSubsequence obj = new LongestConsecutiveSubsequence();
        System.out.println(obj.betterSolution(a));
        System.out.println(obj.optimalSolution(a));

    }

}
