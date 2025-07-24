package com.example.practice.code.arrays;

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

        Map<Integer,ElementFreq> freqmap = new HashMap();

        for(int i:nums){
            if(freqmap.containsKey(i)){
                freqmap.compute(i, (k1, e) -> new ElementFreq(i, e.getFreq() + 1));
            }else{
                freqmap.put(i,new ElementFreq(i,1));
            }
        }

        List<ElementFreq> l = freqmap.values().stream().sorted(new Comparator<ElementFreq>() {
            @Override
            public int compare(ElementFreq o1, ElementFreq o2) {
                return o2.getFreq()-o1.getFreq();
            }
        }).toList();

        int i = 0;

        int[] result = new int[k];

        while(i<k){
            result[i]=l.get(i).getValue();
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