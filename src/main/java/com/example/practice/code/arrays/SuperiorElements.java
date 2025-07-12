package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Also called leading elements.
 * Leading element : any element such that all elements on right of array are less than that element.
 * Brute force: double loop and check for each element if it is leading element
 * Optimal: traverse from right to left and keep track of max element seen so far. If current element is greater than max, then it is leading element
 */
public class SuperiorElements {

    public List<Integer> solution(int[] a){

        int curMax = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        for(int i=a.length-1;i>=0;i--){
            if(a[i]>curMax){
                list.add(a[i]);
                curMax = a[i];
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        SuperiorElements obj = new SuperiorElements();
        System.out.println(obj.solution(a));
    }

}
