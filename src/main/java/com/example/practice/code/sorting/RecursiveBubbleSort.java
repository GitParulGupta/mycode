package com.example.practice.code.sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {

    public void bubbleSort(int[] ar, int n){

        if(n==1) return;

        for(int i=0;i<n-1;i++){
            if(ar[i]>ar[i+1]){
                int temp = ar[i];
                ar[i] = ar[i+1];
                ar[i+1] = temp;
            }
        }

        bubbleSort(ar,n-1);
    }

    public static void main(String[] args){
        RecursiveBubbleSort solution = new RecursiveBubbleSort();
        int[] ar = new int[]{11,4,56,34,90,2};
        solution.bubbleSort(ar, 6);
        System.out.println(Arrays.toString(ar));
    }
}
