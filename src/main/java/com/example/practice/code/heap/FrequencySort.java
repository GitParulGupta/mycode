package com.example.practice.code.heap;

import java.util.*;

/**
 * Given an array of numbers, sort the array in decresing order of frequency
 */
public class FrequencySort {

    public int[] solution(int[] nums){

        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int i:nums){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }

        PriorityQueue<PairFreq> maxheap = new PriorityQueue<>(new Comparator<PairFreq>() {
            @Override
            public int compare(PairFreq o1, PairFreq o2) {
                if(o1.getFreq()==o2.getFreq()){
                    return o1.getValue()-o2.getValue();
                }else{
                    return o2.getFreq()-o1.getFreq();
                }
            }
        });

        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            PairFreq p = new PairFreq(entry.getValue(),entry.getKey());
            maxheap.add(p);
        }

        int[] result = new int[nums.length];
        int i= 0;
        while(!maxheap.isEmpty()){
            PairFreq pf = maxheap.poll();
            int count = 0;
            while(count<pf.getFreq()){
                result[i] = pf.getValue();
                count++;
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] i1 = {1,1,4,5,5,1,2,2,3};
        FrequencySort obj = new FrequencySort();

        System.out.println(Arrays.toString(obj.solution(i1)));
    }


}