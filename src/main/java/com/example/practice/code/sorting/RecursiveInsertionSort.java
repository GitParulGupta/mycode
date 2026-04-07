package com.example.practice.code.sorting;

import java.util.Arrays;

/**
 * Works on the criteria of pushing the maximum in the array towards the end by adjacent swapping
 * TC: O(n^2) - worst and avg case
 * O(n) - Best - if array is sorted
 */
public class RecursiveInsertionSort {

    public void insertionSort(int[] arr, int n){
        if (n <= 1)
            return;

        // Sort first n-1 elements
        insertionSort(arr, n - 1);

        // Insert last element at correct position
        int last = arr[n - 1];
        int j = n - 2;

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = last;
    }

    public static void main(String[] args) {
        int[] input = {12,4,7,15,32,56,23};
        RecursiveInsertionSort obj = new RecursiveInsertionSort();
        obj.insertionSort(input,input.length);
        System.out.println(Arrays.toString(input));
    }

}
