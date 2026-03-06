package com.example.practice.code.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, return an array which has elements such that the element is greater than its neighboring elements i.e.
 * a [i] > max (a[i-1], a[i+1]).
 * The first & last element of original array will be included always in final array. Maintain ordering of elements.
 */
public class PeakElements {

    public int[] getPeakElements(int[] arr){

        if(arr.length == 0){
            return new int[0];
        }
        if(arr.length == 1){
            return arr;
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>Math.max(arr[i-1],arr[i+1])){
                list.add(arr[i]);
            }
        }

        list.add(arr[arr.length-1]);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        PeakElements peakElements = new PeakElements();

        int[] input = new int[]{1,3,2,6,4,8,7};

        System.out.println(Arrays.toString(peakElements.getPeakElements(input)));

    }
}
