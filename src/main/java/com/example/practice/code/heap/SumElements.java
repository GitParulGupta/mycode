package com.example.practice.code.heap;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array of integers and 2 numbers k1 nd k2, find the sum of numbers which lie between k1th smallest and k2th smallest numbers.
 */
public class SumElements {

    //maxHeap
    public int solution(int[] a, int k1, int k2){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i=0;

        while(i<a.length){

            maxHeap.add(a[i]);

            while(maxHeap.size()>k1){
                maxHeap.poll();
            }
            i++;
        }

        int k1Smallest = maxHeap.peek();

        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>(Collections.reverseOrder());
        int j=0;

        while(j<a.length){

            maxHeap2.add(a[j]);

            while(maxHeap2.size()>k2){
                maxHeap2.poll();
            }
            j++;
        }

        int k2Smallest = maxHeap2.peek();
        int sum = 0;

        for(int h:a){
            if(h > k1Smallest && h < k2Smallest){
                sum+=h;
            }else if(h > k2Smallest && h < k1Smallest){
                sum+=h;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1,3,12,5,11,15};
        int k1 =3;
        int k2 = 6;
        SumElements obj = new SumElements();
        System.out.println(obj.solution(a,k1,k2));
    }

}
