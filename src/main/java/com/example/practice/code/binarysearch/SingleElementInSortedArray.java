package com.example.practice.code.binarysearch;

/**
 * Given a sorted array where an element can occur at max 2 times, we need to find the element which appears only once.
 * Example: {1,1,2,2,3,3,4,5,5,6,6}
 * Ans: 4
 */
public class SingleElementInSortedArray {

    public int solution(int[] arr){

        int n=arr.length;
        if(n==1){
            return arr[0];
        }
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];

        int l = 1;
        int h= n-2;

        while (l<=h){
            int mid = (l+h)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }else if((mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1])){
                l = mid+1;
            }else{
                h = mid -1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] input = {1,1,2,2,3,3,4,5,5,6,6};
        SingleElementInSortedArray obj = new SingleElementInSortedArray();
        System.out.println(obj.solution(input));
    }
}
