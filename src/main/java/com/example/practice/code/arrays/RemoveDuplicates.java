package com.example.practice.code.arrays;

/**
 * Given a sorted array, Remove duplicates from the sorted array and return size of resultant array
 * {1,2,2,3,3,3}
 * Brute force - add elements to set. then replace the elements back in the list
 * insertion - O(NlogN) and iteration back is O(N)
 * Optimised using two pointer approach
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] a){
        int i = 0;
        int j = 1;

        while(j<a.length){
            if(a[i]!=a[j]){
                a[i+1]=a[j];
                i++;
            }
            j++;
        }

        return i+1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,3};
        RemoveDuplicates obj = new RemoveDuplicates();
        System.out.println(obj.removeDuplicates(a));
    }

}
