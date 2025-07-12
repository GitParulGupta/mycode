package com.example.practice.code.arrays;

import java.util.Arrays;

/**
 * Given positive and negative elements in array. Rearrange the elements by sign. It is mentioned that count of positive elements = count of negative elements = n/2
 * Array doesnt have 0 elements
 * Brute force - take 2 extra arrays of size n/2 each anf form negative and positive arrays. Then arrange them back to original array
 *
 * Complexity - O(2N) space - O(N)
 */
public class RearrangeElementsBySign {
    public void solution(int[] a){

        int[] temp = new int[a.length];
        int pos = 0;
        int neg = 1;

        System.out.println("Before: "+Arrays.toString(a));

        for (int j : a) {
            if (j > 0) {
                temp[pos] = j;
                pos = pos + 2;
            } else {
                temp[neg] = j;
                neg = neg + 2;
            }
        }

        System.out.println("After: "+Arrays.toString(temp));
    }

    public static void main(String[] args) {
        RearrangeElementsBySign obj = new RearrangeElementsBySign();
        int[] a = {3,1,-2,-4,5,-1};
        obj.solution(a);
    }
}
