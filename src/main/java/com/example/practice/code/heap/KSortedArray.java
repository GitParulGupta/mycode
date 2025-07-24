package com.example.practice.code.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Also called nearly sorted array
 * Given an array arr[] and a number k . The array is sorted in a way that every element is at max k distance away from it sorted position. It means if we completely sort the array, then the index of the element can go from i - k to i + k where i is index in the given array. Our task is to completely sort the array.
 * Examples:
 * Input: arr= [6, 5, 3, 2, 8, 10, 9], k = 3
 * Output: [2, 3, 5, 6, 8, 9, 10]
 * Input: arr[]= [1, 4, 5, 2, 3, 6, 7, 8, 9, 10], k = 2
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Option 1: Merge sort to sort any array
 * Option 2: Heap approach
 */
public class KSortedArray {

    //Intution is any element is displaced by max k places to left or right
    public int[] solution(int[] ar , int k){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i=0; int j= 0;

        while(i<ar.length){

            minHeap.add(ar[i]);

            while(minHeap.size()>k){
                ar[j] = minHeap.poll();
                j++;
            }
            i++;
        }

        while(!minHeap.isEmpty()){
            ar[j] = minHeap.poll();
            j++;
        }

        return ar;
    }

    public static void main(String[] args) {
        int[] i = {6,5,3,2,8,10,9};
        KSortedArray obj = new KSortedArray();
        System.out.println(Arrays.toString(obj.solution(i,3)));
    }

}
