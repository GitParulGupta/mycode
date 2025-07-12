package com.example.practice.code.binarysearch;


/**
 * Given a sorted array which has been rotated about a pivot, find the index of a given number x. Return -1 if element does not exist
 * Elements can be duplicate
 * Example: array = {3,1,2,3,3,3};
 * target = 1;
 *
 * Here important is to identify which portion of the array is sorted at each iteration
 * Our conditions will not work if a[low]==a[mid]==a[high]
 *
 */
public class SearchInRotatedArray2 {

    public int searchInRotatedArray(int[] array, int x){

        int low = 0;
        int high = array.length-1;

        while(low<=high){

            int mid = (low+high)/2;

            if(array[mid]==x){
                return mid;
            }

            if(array[mid]==array[low] && array[mid]==array[high]){
                low=low+1;
                high=high-1;
                continue;
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
        int[] a = {3,1,2,3,3,3};

        int[] target = {1,3};

        SearchInRotatedArray2 obj = new SearchInRotatedArray2();

        for(int i:target){
            System.out.println("Index of " + i+" = "+obj.searchInRotatedArray(a,i));
        }
    }

}
