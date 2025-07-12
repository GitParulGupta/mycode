package com.example.practice.code.arrays;


import java.util.Arrays;

/**
 * Given an array, move all the zeros towards the end of array
 */
public class MoveZerosEnd {

    public void moveZeros(int[] a){

        if(a.length==1){
            return;
        }
        int i = 0;
        int j = 0;

        while(i<a.length){

            if(a[i]!=0){
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                j++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,0,2,3,2,0,0,4,5,1};
        MoveZerosEnd obj = new MoveZerosEnd();
        obj.moveZeros(a);
        System.out.println(Arrays.toString(a));
        int[] a2 = {0,0,0,0,2};
        obj.moveZeros(a2);
        System.out.println(Arrays.toString(a2));
        int[] a3 = {0,0,0,0,0};
        obj.moveZeros(a3);
        System.out.println(Arrays.toString(a3));
        int[] a4 = {3,0,0,0,0};
        obj.moveZeros(a4);
        System.out.println(Arrays.toString(a4));
        int[] a5 = {1,2};
        obj.moveZeros(a5);
        System.out.println(Arrays.toString(a5));
        int[] a6 = {0};
        obj.moveZeros(a6);
        System.out.println(Arrays.toString(a6));
    }

}
