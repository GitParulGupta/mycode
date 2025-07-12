package com.example.practice.code.binarysearch;

import java.util.Map;

/**
 * Find the minimum element in a sorted rotated array
 * Example: {7,8,9,1,2,3,4,5,6}, Min = 1
 */
public class MinimumInSortedArray {

    public int findMinimum(int[] a){

        int low = 0;
        int high = a.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){

            int mid = (low+high)/2;

            if(a[low]<=a[mid]){
                ans = Math.min(ans,a[low]);
                low = mid +1;
            }else{
                high = mid -1;
                ans = Math.min(ans,a[mid]);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {7,8,9,1,2,4,5};
        MinimumInSortedArray obj = new MinimumInSortedArray();
        System.out.println(obj.findMinimum(a));
    }
}
