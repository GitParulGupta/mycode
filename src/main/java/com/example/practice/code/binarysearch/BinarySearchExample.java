package com.example.practice.code.binarysearch;

/**
 *Given a sorted unique array, find given target from the array. return -1 if element does not exist else return the index of the element.
 */
public class BinarySearchExample {

    public int binarySearch(int[] ar, int target){

        int low = 0;
        int high = ar.length-1;

        while(low<=high){

            int mid = (high+low)/2;

            if(target==ar[mid]){
                return mid;
            }else if(target>ar[mid]){
                low = mid+1;
            }else{
                high = mid -1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {

        int[] input = {3,4,6,8,11,17,19};
        int target1 = 6;
        int target2 = 3;
        int target3 = 19;
        int target4 = 12;

        BinarySearchExample bs = new BinarySearchExample();

        System.out.println(bs.binarySearch(input,target1));

        System.out.println(bs.binarySearch(input,target2));

        System.out.println(bs.binarySearch(input,target3));

        System.out.println(bs.binarySearch(input,target4));

    }

}
