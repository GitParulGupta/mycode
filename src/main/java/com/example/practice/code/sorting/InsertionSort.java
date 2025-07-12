package com.example.practice.code.sorting;

import java.util.Arrays;

/**
 * Works on the criteria of pushing the maximum in the array towards the end by adjacent swapping
 * TC: O(n^2) - worst and avg case
 * O(n) - Best - if array is sorted
 */
public class InsertionSort {

    public void insertionSort(int[] a){
        int n=a.length;
        for(int i=0;i<n;i++){
            int j=i;
            while(j>0 && a[j-1]>a[j]){
                int temp = a[j-1];
                a[j-1] = a[j];
                a[j] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] input = {12,4,7,15,32,56,23};
        InsertionSort obj = new InsertionSort();
        obj.insertionSort(input);
    }

}
