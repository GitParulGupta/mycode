package com.example.practice.code.binarysearch;


import java.util.Arrays;

/**
 * Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
 * Allocate books in such a way that:
 *
 * Each student gets at least one book.
 * Each book should be allocated to only one student.
 * Book allocation should be in a contiguous manner.
 * You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1
 * Example 1:
 *
 * Input Format: n = 4, m = 2, arr[] = {12, 34, 67, 90}
 * Result: 113
 * Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.
 *
 * Example 2:
 * Input Format:
 *  n = 5, m = 4, arr[] = {25, 46, 28, 49, 24}
 * Result:
 *  71
 */
public class AllocateBooks {

    public int solution(int[] ar, int m){

        int minElement = ar[0];
        for(int i= 1;i<ar.length;i++){
            if(ar[i]<minElement){
                minElement = ar[i];
            }
        }

        int low = minElement; //minimumAllocation
        int high = Arrays.stream(ar).sum(); //maximumAllocation - all books to 1 student
        int result = -1;
        while(low<=high){

            int mid  = (low+high)/2;

            if(isAllocationPossible(mid,ar,m)){
                result = mid;
                high = mid -1;//we want to search the smallest possible number
            }else{
                low = mid+1;
            }
        }

        return result;

    }

    private boolean isAllocationPossible(int barrier, int[] ar, int m) {

        int allocatedStudents = 1;
        int numPages = 0;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > barrier) {
                return false;
            } else if (ar[i] + numPages > barrier) {
                allocatedStudents++;
                numPages = ar[i];
            } else {
                numPages += ar[i];
            }
        }

        if (allocatedStudents > m) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        AllocateBooks allocateBooks = new AllocateBooks();
        System.out.println(allocateBooks.solution(new int[]{12,34,67,90},2));
        System.out.println(allocateBooks.solution(new int[]{1,4,4},3));
    }

}
