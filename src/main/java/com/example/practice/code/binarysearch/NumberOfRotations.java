package com.example.practice.code.binarysearch;

/**
 * Find the minimum element in a sorted rotated array
 * Example: {7,8,9,1,2,3,4,5,6}, Ans = 3
 */
public class NumberOfRotations {

    public int findNumRotations(int[] a){

        int low = 0;
        int high = a.length-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while(low<=high){

            int mid = (low+high)/2;

            if(a[low]<=a[mid]){
                if(a[low]<ans) {
                    index = low;
                    ans = a[low];
                }
                low = mid + 1;
            }else{
                high = mid -1;
                if(a[mid]<ans){
                    ans = a[mid];
                    index = mid;
                }
                ans = Math.min(ans,a[mid]);
            }

        }

        return index;
    }

    public static void main(String[] args) {
        int[] a = {7,8,9,1,2,4,5};
        NumberOfRotations obj = new NumberOfRotations();
        System.out.println(obj.findNumRotations(a));
    }
}
