package com.example.practice.code.arrays;

import java.util.List;

/**
 * Important from Interview perspective
 * Given an array, find the second-smallest element in the array.
 * Brute Force - sort the array. Find smallest = a[0]. then iterate the array from start and find the  element greater than the smallest element
 * O(NlogN)
 * Better Solution - 2 iterations - 1st find the smallest element. then in second iteration find the smallest element which is greater than the largest element
 * O(2N)
 * Optimal Solution - take 2 variables, smallest & secSmallest. Keep largest as a[0] and secSmallest = Integer.MAX_VALUE. the iterate over the array. At any instant, if we find element smaller than smallest, the set secSmallest as smallest and smallest as a[i]
 * Don't update if a[i] = smallest
 * if a[i] >  smallest but a[i] < secSmallest then update secSmallest
 *
 */
public class SecondSmallest {

    public int findSecondSmallest(List<Integer> a){
        int smallest = a.getFirst();
        int secSmallest = Integer.MAX_VALUE;

        for (Integer integer : a) {
            if (integer < smallest) {
                secSmallest = smallest;
                smallest = integer;
            } else if (integer > smallest && integer < secSmallest) {
                secSmallest = integer;
            }
        }

        return secSmallest;
    }

    public static void main(String[] args) {
        List<Integer> input1 = List.of(1,2,4,7,7,5);
        List<Integer> input2 = List.of(1,7,7,7,7,7);
        List<Integer> input3 = List.of(7,7,7,7,7,7);

        List<List<Integer>> input = List.of(input1,input2,input3);

        SecondSmallest obj = new SecondSmallest();

        for(List<Integer> l:input){
            System.out.println(obj.findSecondSmallest(l));
        }


    }
}
