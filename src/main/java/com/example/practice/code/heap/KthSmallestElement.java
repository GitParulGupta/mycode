package com.example.practice.code.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    //max element on top
    public int solution(int[] nums, int K){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);

            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();

    }

    public static void main(String[] args) {
        int[] ar = {7,10,4,3,20,13,15};

        KthSmallestElement obj = new KthSmallestElement();
        System.out.println(obj.solution(ar,3));
    }
}
