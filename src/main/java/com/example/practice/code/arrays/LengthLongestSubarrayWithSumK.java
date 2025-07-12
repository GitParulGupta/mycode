package com.example.practice.code.arrays;

import java.util.Arrays;

/**
 * Find the longest sub-array of sum K.
 * TC: O(2N)
 */
public class LengthLongestSubarrayWithSumK {

    public int solution(int[] a, int k){

        int sum = 0; int j=0; int length = 0;
        int maxLength = 0;
        int i = 0;
        while(j<a.length){
            sum = sum + a[j];
            j++;
            length++;
            while(i<=j && sum>k){
                sum = sum - a[i];
                i++;
                length--;
            }
            if(sum==k) {
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;

    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,1,1,1,1,1,3,3};
        int k1 = 3;
        int k11 =5;
        int k111 = 20;

        int[] a2 = {3,3,3,3,3,3};
        int k2 = 3;
        int k22 = 36;


        LengthLongestSubarrayWithSumK obj = new LengthLongestSubarrayWithSumK();
        System.out.println("Input:"+Arrays.toString(a1)+" k:"+k1+" "+obj.solution(a1,k1));
        System.out.println("Input:"+Arrays.toString(a1)+" k:"+k11+" "+obj.solution(a1,k11));
        System.out.println("Input:"+Arrays.toString(a1)+" k:"+k111+" "+obj.solution(a1,k111));
        System.out.println("Input:"+Arrays.toString(a2)+" k:"+k2+" "+obj.solution(a2,k2));
        System.out.println("Input:"+Arrays.toString(a2)+" k:"+k22+" "+obj.solution(a1,k22));
    }

}
