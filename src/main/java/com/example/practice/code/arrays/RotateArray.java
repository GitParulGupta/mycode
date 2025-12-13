package com.example.practice.code.arrays;

import java.util.Arrays;

/**
 * Given an array, rotate the array to left by d in place
 * a = {1,2,3,4,5,6,7} => result = {4,5,6,7,1,2,3} when d = 3
 *
 *  * Given an array, rotate the array to right by d in place
 *  * a = {1,2,3,4,5,6,7} => result = {5,6,7,1,2,3,4} when d = 3
 *
 *  BruteForce solution
 */
public class RotateArray {

    public int[] rotateLeft(int[] a, int d){

        d = d%a.length;

        int[] temp = new int[d];

        System.arraycopy(a, 0, temp, 0, d); //imp
        //at this point we have temp = {1,2,3}
        int size = a.length;

        for(int i=d;i<size;i++){
            a[i-d] = a[i];
        }

        //at this point we have a = {4,5,6,7,5,6,7}

        for(int i=size-d;i<size;i++){
            a[i] = temp[i-(size-d)];
        }

        return a;
    }

    public int[] rotateLeft2(int[] a, int d){

        int[] temp = a.clone();
        int n = a.length;
        for(int i=0;i<n;i++){
            a[(i+(n-d))%n]=temp[i];
        }
        return a;
    }

    public int[] rotateRight2(int[] a, int d){

        int[] temp = a.clone();
        int n = a.length;
        for(int i=0;i<n;i++){
            a[(i+d)%n] = temp[i];
        }
        return a;
    }

    public int[] rotateRight(int[] a, int d){

        d = d%a.length;
        int[] temp = new int[d];
        int size = a.length;
        for(int i=size-d;i<size;i++){
            temp[i-(size-d)] = a[i];
        }
        //at this point we have temp = {5,6,7}

        for(int i=d;i>=0;i--){
            a[i+d] = a[i];
        }
        //at this point we have a = {1,2,3,1,2,3,4}

        for(int i=0;i<d;i++){
            a[i] = temp[i];
        }

        return a;
    }

    public static void main(String[] args) {
        int[] leftRotateInput = {1,2,3,4,5,6,7};

        int[] rightRotateInput = {1,2,3,4,5,6,7};

        RotateArray r = new RotateArray();

        //System.out.println(Arrays.toString(r.rotateLeft(leftRotateInput, 3)));
        //System.out.println(Arrays.toString(r.rotateRight(rightRotateInput, 3)));

        int[] leftRotateInput2 = {1,2,3,4,5,6,7};
        int[] leftRotateInput3 = {1,2,3,4,5,6,7};

        int[] rightRotateInput2 = {1,2,3,4,5,6,7};

        //System.out.println(Arrays.toString(r.rotateLeft(leftRotateInput2, 6)));
        System.out.println(Arrays.toString(r.rotateLeft2(leftRotateInput3, 3)));
        System.out.println(Arrays.toString(r.rotateRight2(rightRotateInput2, 5)));
        //System.out.println(Arrays.toString(r.rotateRight(rightRotateInput2, 6)));
    }

}
