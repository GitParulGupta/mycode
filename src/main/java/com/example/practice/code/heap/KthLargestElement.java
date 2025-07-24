package com.example.practice.code.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    //min element on top
    public int solution(int[] nums, int K){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }

        return minHeap.peek();

    }

    public static void main(String[] args) {
        int[] ar = {7,10,4,3,20,13,15};

        KthLargestElement obj = new KthLargestElement();
        System.out.println(obj.solution(ar,3));
    }

}
