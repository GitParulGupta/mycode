package com.example.practice.code.arrays;


import java.util.List;

/**
 * Important from Interview perspective
 * Given an array, find the second-largest element in the array.
 * Brute Force - sort the array. Find largest = a[n-1] where n is length of array. then iterate the array from back and find the greatest element smaller than the largest element
 * O(NlogN)
 * Better Solution - 2 iterations - 1st find the largest element. then in second iteration find the largest element which is less than the largest element
 * O(2N)
 * Optimal Solution - take 2 variables, largest & seclargest. Keep largest as a[0] and seclargest = Integer.MIN_VALUE. the iterate over the array. At any instant, if we find element greater than largest, the set seclargest as largest and largest as a[i]
 * Don't update if a[i] = largest
 * if a[i] < largest but a[i] > seclargest then update seclargest
 *
 */
public class SecondLargestElement {

    public int findSecondLargest(List<Integer> a){
        int largest = a.getFirst();
        int secLargest = Integer.MIN_VALUE;

        for (Integer integer : a) {
            if (integer > largest) {
                secLargest = largest;
                largest = integer;
            } else if (integer < largest && integer > secLargest) {
                secLargest = integer;
            }
        }

        return secLargest;
    }

    //sceanrio where we have duplicates and negative values in the array
    //return -1 if no sec largest value exists
    //Companies - Oracle
    public int findSecondLargestNegativeValues(List<Integer> a){
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;

        for (Integer integer : a) {
            if (integer > largest) {
                secLargest = largest;
                largest = integer;
            } else if (integer > secLargest && integer!=largest) {
                secLargest = integer;
            }
        }

        if(secLargest==Integer.MIN_VALUE) return -1;

        return secLargest;
    }

    public static void main(String[] args) {
        List<Integer> input1 = List.of(1,2,4,7,7,5);
        List<Integer> input2 = List.of(1,7,7,7,7,7);
        List<Integer> input3 = List.of(7,7,7,7,7,7);

        List<List<Integer>> input = List.of(input1,input2,input3);

        SecondLargestElement obj = new SecondLargestElement();

        for(List<Integer> l:input){
            System.out.println(obj.findSecondLargest(l));
        }


    }

}
