package com.example.practice.code.binarysearch;


/**
 * This related to finding insert position for element in sorted array
 */
public class LowerBound {

    public int lowerBound(int[] ar, int target){

        int low = 0;
        int high = ar.length-1;
        int ans = ar.length;

        while(low<=high){

            int mid = (high+low)/2;

            if(ar[mid]>=target){
                ans = mid;
                high = mid -1;
            }else{
                low = mid +1;
            }

        }

        return ans;

    }

    public static void main(String[] args) {

        int[] input = {3,4,6,8,11,17,19};
        int target1 = 6; //2
        int target2 = 3; //0
        int target3 = 19;//6
        int target4 = 20;//7

        LowerBound lb = new LowerBound();

        System.out.println(lb.lowerBound(input,target1));

        System.out.println(lb.lowerBound(input,target2));

        System.out.println(lb.lowerBound(input,target3));

        System.out.println(lb.lowerBound(input,target4));

    }

}
