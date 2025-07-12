package com.example.practice.code.binarysearch;

/**
 * Given a sorted array, fine the first and last occurrence of a number x. If the number is not present in the array return -1;
 */
public class FirstNLastOccurrenceOfNumber {

    public int findFirstOccurrence(int[] a, int x){
        int low =0;
        int high = a.length-1;

        int ans = a.length;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]>=x){
                ans = mid;
                high = mid -1;
            }else{
                low = mid +1;
            }
        }

        if(ans<a.length && a[ans]==x){
            return ans;
        }else{
            return -1;
        }

    }

    public int findLastOccurrence(int[] a, int x){
        int low =0;
        int high = a.length-1;

        int ans = a.length;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]>x){
                ans = mid;
                high = mid -1;
            }else{
                low = mid +1;
            }
        }

        if(ans>0 && a[ans-1]==x){
            return ans-1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,4,6,8,8,8,11,13};

        int[] target = {2,6,8,13,14};

        FirstNLastOccurrenceOfNumber obj = new FirstNLastOccurrenceOfNumber();

        for(int i:target){
            System.out.println("First: "+obj.findFirstOccurrence(a,i)+" Last:"+obj.findLastOccurrence(a,i));
        }
    }

}
