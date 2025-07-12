package com.example.practice.code.arrays;


import java.util.Arrays;

/**
 *
 * Useful for problem sort array containing only 0,1,2
 * To solve above - brute force is to store elements in another array first selecting 0 then 1 then2
 * Better - 3 variables to store count of 0 1 and 2. then loop from 0 -> zeroCount-1, zeroCount ->oneCount-1 && oneCount -> twoCount-1 to fill the array
 * Optimal solution is DutchNationalFlagAlgorithm
 *
 * Algo says -->
 * everything between {0....low-1} is 0
 * everything between {low....mid-1} is 1
 * everything between {high+1....n-1} is 2
 * Between mid...high -- we can have any random numbers 0,1,2
 *
 * {0....low-1}{low...mid-1}{mid...high}{high+1....n-1}
 * {000000000}{111111111111}{0/1/2}{222222222}
 *
 * Algo says assume low = 0; mid =0; high = n-1;
 * if a[mid]==0 => swap (low,mid) elements, low++ mid ++
 * if a[mid]==1 => mid++
 * if a[mid]==2 => swap (mid, high) elements, high--
 *
 */
public class DutchNationalFlagAgo {

    private void swap(int[] a, int first, int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public void solution(int[] a){
        System.out.println("Before sorting:"+Arrays.toString(a));
        int low =0; int mid = 0; int high = a.length-1;

        while(mid<=high){
            if(a[mid] == 0){
                swap(a,low,mid);
                low++;
                mid++;
            }else if(a[mid]==1){
                mid++;
            }else{
                swap(a,mid,high);
                high--;
            }
        }

        System.out.println("After sorting:"+Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] input = {0,1,2,0,1,2,1,2,0,0,0,1};
        DutchNationalFlagAgo obj = new DutchNationalFlagAgo();
        obj.solution(input);
    }

}
