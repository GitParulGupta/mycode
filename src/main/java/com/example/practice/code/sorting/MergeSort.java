package com.example.practice.code.sorting;

import java.util.Arrays;

public class MergeSort {

    public void solution(int[] nums){

        System.out.println("Before Sort: "+Arrays.toString(nums));
        int low = 0;
        int high = nums.length-1;

        mergeSortSolution(nums,low,high);

        System.out.println("After Sort: "+Arrays.toString(nums));

    }

    private void mergeSortSolution(int[] nums, int low, int high){
        if(low>=high){
            return ;
        }
        int mid =  (low+high)/2;
        mergeSortSolution(nums,low,mid);
        mergeSortSolution(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    private void merge(int[] nums, int low, int mid, int high) {

        int n1 = mid-low+1;
        int n2 = high-mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++){
            L[i] = nums[low+i];
        }

        for(int i=0;i<n2;i++){
            R[i] = nums[mid+1+i];
        }

        int i=0; int j=0;
        int k=low;

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                nums[k]=L[i];
                i++;
            }else{
                nums[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            nums[k]=L[i];
            i++;
            k++;
        }

        while(j<n2){
            nums[k]=R[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] i = {1,4,2,7,5};

        MergeSort obj = new MergeSort();

        obj.solution(i);
    }

}
