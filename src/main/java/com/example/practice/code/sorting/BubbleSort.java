package com.example.practice.code.sorting;

import java.util.Arrays;

/**
 * Works on the criteria of pushing the maximum in the array towards the end by adjacent swapping
 * TC: O(n^2) - worst and avg case
 * O(n) - Best - if array is sorted
 */
public class BubbleSort {

    public void bubbleSort(int[] a){
        int n=a.length;
        for(int i=n-1;i>=0;i--){
            int swap = 0;
            for(int j=0;j<=i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1] = temp;
                    swap =1;//if no swap at all -> then no need for further iterations
                }
            }
            if(swap==1){
                break;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] input = {12,4,7,15,32,56,23};
        BubbleSort obj = new BubbleSort();
        obj.bubbleSort(input);
    }

}
