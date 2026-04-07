package com.example.practice.code.arrays;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 * The test cases are generated such that the answer is always unique.
 * You may return the output in any order.
 * Example 1:
 * Input: nums = [1,2,2,3,3,3], k = 2
 * Output: [2,3]
 * Example 2:
 * Input: nums = [7,7], k = 1
 * Output: [7]
 */
public class TopKFrequentElements {

    public int[] solution (int[] nums, int k){

       Map<Integer,Integer> map = new TreeMap<>();
       for(int i:nums){
           map.put(i,map.getOrDefault(i,0)+1);
       }

       List<Map.Entry<Integer,Integer>> list = map.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
           @Override
           public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
               return o2.getValue().compareTo(o1.getValue());
           }
       }).toList();

       int[] result = new int[k];

       int i= 0;

       while(i<k){
           result[i] = list.get(i).getKey();
           i++;
       }
       return result;
    }

    public static void main(String[] args) {
        int[] input1 = {1,2,2,3,3,3};
        int[] input2 = {7,7};

        int k1 = 2;
        int k2 = 1;

        TopKFrequentElements obj = new TopKFrequentElements();
        int[] result1 = obj.solution(input1,k1);
        System.out.println(Arrays.toString(result1));
        int[] result2 = obj.solution(input2,k2);
        System.out.println(Arrays.toString(result2));
    }

}

class ElementFreq{
    int value;
    int freq;

    ElementFreq(int value1, int freq1){
        this.freq = freq1;
        this.value = value1;
    }

    public int getValue() {
        return value;
    }

    public int getFreq() {
        return freq;
    }
}