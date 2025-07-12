package com.example.practice.code.arrays;

import java.util.Arrays;

/**
 * This is also called alternative numbers problem
 * Given positive and negative elements in array. Rearrange the elements by sign. It is mentioned that count of positive elements = count of negative elements = n/2
 * Array doesnt have 0 elements
 * Brute force - take 2 extra arrays of size n/2 each anf form negative and positive arrays. Then arrange them back to original array
 *
 * Complexity - O(2N) space - O(N)
 */
public class RearrangeElementsBySign2 {
    public void solution(int[] a){

        int[] temp = new int[a.length];
        int pos = 0;
        int neg = 1;

        int posCount = 0;
        int negCount = 0;

        for(int i:a){
            if(i>0)posCount++;
            else negCount++;
        }

        System.out.println("Before: "+Arrays.toString(a));

        int i = 0;

        while(posCount>0 && negCount>0){
            if(a[i]>0){
                temp[pos] = a[i];
                pos+=2;
                posCount--;
            }else{
                temp[neg] = a[i];
                neg+=2;
                negCount--;
            }
            i++;
        }

        while(i<a.length){
            temp[i]=a[i];
            i++;
        }

        System.out.println("After: "+Arrays.toString(temp));
    }

    public static void main(String[] args) {
        RearrangeElementsBySign2 obj = new RearrangeElementsBySign2();
        int[] a = {3,1,-2,-4,5,-1,-3,-4};
        obj.solution(a);
    }
}
