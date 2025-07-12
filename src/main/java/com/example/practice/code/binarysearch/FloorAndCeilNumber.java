package com.example.practice.code.binarysearch;


/**
 * Floor : Largest number in array < given number x
 * Ceil: Largest number in array >= given number x
 */
public class FloorAndCeilNumber {

    public int findFloorOfNumber(int[] array, int x){

        int low = 0;
        int high = array.length -1;

        int ans = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(array[mid]<x){
                ans = array[mid];
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }

        return ans;


    }

    public int findCeilOfNumber(int[] array, int x){

        LowerBound obj = new LowerBound();

        int lb = obj.lowerBound(array,x);

        if(lb>-1 && lb<array.length){
            return array[lb];
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] sample = {10,20,25,25,30,40,50};

        int x = 22;

        FloorAndCeilNumber obj = new FloorAndCeilNumber();
        System.out.println("Floor of" + x +" "+obj.findFloorOfNumber(sample,x));

        System.out.println("Ceil of" + x +" "+obj.findCeilOfNumber(sample,x));
    }

}
