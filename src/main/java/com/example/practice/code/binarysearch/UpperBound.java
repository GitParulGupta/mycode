package com.example.practice.code.binarysearch;

public class UpperBound {

    public int upperBound(int[] ar, int target){

        int low = 0;
        int high = ar.length-1;
        int ans = ar.length;

        while(low<=high){

            int mid = (high+low)/2;

            if(ar[mid]>target){
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
        int target1 = 6; //3
        int target2 = 3; //1
        int target3 = 19;//7
        int target4 = 20;//7

        UpperBound upperBound = new UpperBound();

        System.out.println(upperBound.upperBound(input,target1));

        System.out.println(upperBound.upperBound(input,target2));

        System.out.println(upperBound.upperBound(input,target3));

        System.out.println(upperBound.upperBound(input,target4));

    }

}
