package com.example.practice.code.binarysearch;

/**
 * Given a sorted array find the peak element a[i] st a[i]>a[i-1] && a[i]>a[i+1]. Assume that on both ends of array we have - infinity. There may be multiple peaks. Return any peak.
 * Example: {1,2,3,4,5,6,7,8,5,1}
 * Ans: 8
 */
public class PeakElement {

    public int solution(int[] arr){

        int n=arr.length;
        if(n==1){
            return arr[0];
        }
        if(arr[0]>arr[1]) return arr[0];
        if(arr[n-1]>arr[n-2]) return arr[n-1];

        int l = 1;
        int h= n-2;

        while (l<=h){
            int mid = (l+h)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return arr[mid];
            }else if(arr[mid]>arr[mid-1]){
                l = mid+1;
            }else{
                h = mid -1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,5,1};

        int[] input2 = {1,2,1,4,5,6,7,4,5,1};
        PeakElement obj = new PeakElement();
        System.out.println(obj.solution(input));
        System.out.println(obj.solution(input2));
    }
}
