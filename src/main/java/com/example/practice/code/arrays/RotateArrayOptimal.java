package com.example.practice.code.arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array, rotate the array to left by d in place
 * a = {1,2,3,4,5,6,7} => result = {4,5,6,7,1,2,3} when d = 3
 *
 *  * Given an array, rotate the array to right by d in place
 *  * a = {1,2,3,4,5,6,7} => result = {5,6,7,1,2,3,4} when d = 3
 *
 *  BruteForce solution
 */
public class RotateArrayOptimal {

    private void reverse(int[] a, int start, int end){
        while(start<=end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public int[] rotateLeft(int[] a, int d){
        reverse(a,0,d-1);
        reverse(a,d,a.length-1);
        reverse(a,0,a.length-1);
        return a;
    }

    public int[] rotateRight(int[] a, int d){
        reverse(a,0,a.length-1);
        reverse(a,0,d-1);
        reverse(a,d,a.length-1);
        return a;
    }

    public static void main(String[] args) {
        int[] leftRotateInput = {1,2,3,4,5,6,7};

        int[] rightRotateInput = {1,2,3,4,5,6,7};

        RotateArrayOptimal r = new RotateArrayOptimal();

        System.out.println(Arrays.toString(r.rotateLeft(leftRotateInput, 3)));
        System.out.println(Arrays.toString(r.rotateRight(rightRotateInput, 3)));

        int[] leftRotateInput2 = {1,2,3,4,5,6,7};

        int[] rightRotateInput2 = {1,2,3,4,5,6,7};

        System.out.println(Arrays.toString(r.rotateLeft(leftRotateInput2, 6)));
        System.out.println(Arrays.toString(r.rotateRight(rightRotateInput2, 6)));
    }

}
