package com.example.practice.code.sorting;

import java.util.Arrays;

/**
 * Works on the criteria of find the minimum in the array and place at beginning of unsorted array
 * TC: O(n^2)
 */
public class SelectionSort {

    public void selectionSort(int[] a){
        int n=a.length;
        for(int i=0;i<=n-2;i++){
            int min = i;
            for(int j=i;j<=n-1;j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }

            int temp = a[i];
            a[i]=a[min];
            a[min] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] input = {12,4,7,15,32,56,23};
        SelectionSort obj = new SelectionSort();
        obj.selectionSort(input);
    }

}
