package com.example.practice.code.binarysearch;

/**
 * Given a sorted array, fine the first and last occurrence of a number x. If the number is not present in the array return -1;
 */
public class FirstNLastOccurrenceOfNumberBS {

    public int findFirstOccurrence(int[] a, int x){
        int low =0;
        int high = a.length-1;

        int first = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]==x){
                first = mid;
                high = mid -1;
            } else if (a[mid]<x) {
                low = mid +1;
            } else{
                high = mid -1;
            }
        }

        return first;

    }

    public int findLastOccurrence(int[] a, int x){
        int low =0;
        int high = a.length-1;

        int last = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]==x){
                last = mid;
                low = mid +1;
            } else if (a[mid]<x) {
                low = mid +1;
            } else{
                high = mid -1;
            }
        }

        return last;
    }

    public static void main(String[] args) {
        int[] a = {2,4,6,8,8,8,11,13};

        int[] target = {2,6,8,13,14};

        FirstNLastOccurrenceOfNumberBS obj = new FirstNLastOccurrenceOfNumberBS();

        for(int i:target){
            System.out.println("First: "+obj.findFirstOccurrence(a,i)+" Last:"+obj.findLastOccurrence(a,i));
        }
    }

}
