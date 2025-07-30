package com.example.practice.code.heap;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class KMostFrequentNumber {

    public int[] solution(int[] nums, int k){

        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int i:nums){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }

        PriorityQueue<PairFreq> minheap = new PriorityQueue<>(new Comparator<PairFreq>() {
            @Override
            public int compare(PairFreq o1, PairFreq o2) {
                return o1.getFreq()-o2.getFreq();
            }
        });

        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){

            PairFreq p = new PairFreq(entry.getValue(),entry.getKey());
            minheap.add(p);

            while(minheap.size()>k){
                minheap.poll();
            }
        }

        int[] result = new int[minheap.size()];
        int i= 0;
        for(PairFreq pf:minheap){
            result[i] = pf.getValue();
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] i1 = {1,1,1,2,2,3};
        KMostFrequentNumber obj = new KMostFrequentNumber();

        System.out.println(Arrays.toString(obj.solution(i1,2)));
    }


}

class PairFreq{


    int freq;
    int value;

    PairFreq(int freq,int value){
        this.value = value;
        this.freq = freq;
    }

    public int getFreq() {
        return freq;
    }

    public int getValue() {
        return value;
    }
}