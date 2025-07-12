package com.example.practice.code.binarysearch;


/**
 * Given a sorted array which has been rotated about a pivot, find the index of a given number x. Return -1 if element does not exist
 *
 * Example: array = {7,8,9,1,2,3,4,5,6};
 * target = 1;
 *
 * Here important is to identify which portion of the array is sorted at each iteration
 *
 */
public class SearchInRotatedArray1 {

    public int searchInRotatedArray(int[] array, int x){

        int low = 0;
        int high = array.length-1;

        while(low<=high){

            int mid = (low+high)/2;

            if(array[mid]==x){
                return mid;
            }
            if(array[low]<=array[mid]){

                if(array[low]<=x && x<=array[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }

            }else {
                if(array[mid]<=x && x<=array[high]){
                    low = mid +1;
                }else{
                    high = mid-1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] a = {7,8,9,1,2,3,4,5,6};

        int[] target = {1,2,7,6};

        SearchInRotatedArray1 obj = new SearchInRotatedArray1();

        for(int i:target){
            System.out.println("Index of " + i+" = "+obj.searchInRotatedArray(a,i));
        }
    }

}
