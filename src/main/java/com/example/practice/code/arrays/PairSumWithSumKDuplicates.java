package com.example.practice.code.arrays;

import java.util.*;

/**
 * You are given an integer array 'ARR' of size 'N' and an integer 'S'. Your task is to return the list of all pairs of elements such that each sum of elements of each pair equals 'S'.
 * Note:
 * Each pair should be sorted i.e the first value should be less than or equals to the second value.
 *
 * Return the list of pairs sorted in non-decreasing order of their first value. In case if two pairs have the same first value, the pair with a smaller second value should come first.
 * Sample Input 1:
 * 5 5
 * 1 2 3 4 5
 * Sample Output 1:
 * 1 4
 * 2 3
 * Explanation For Sample Output 1:
 * Here, 1 + 4 = 5
 *       2 + 3 = 5
 * Hence the output will be, (1,4) , (2,3).
 * Sample Input 2:
 * 5 0
 * 2 -3 3 3 -2
 * Sample Output 2:
 * -3 3
 * -3 3
 * -2 2
 */
public class PairSumWithSumKDuplicates {

    public List<List<Integer>> pairSum(int[] arr, int s) {

        Arrays.sort(arr);
        Map<Integer,List<Integer>> indexMap = new LinkedHashMap<>();

        for(int i=0;i<arr.length;i++){
            if(indexMap.containsKey(arr[i])){
                List<Integer> tempList = indexMap.get(arr[i]);
                tempList.add(i);
            }else{
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                indexMap.put(arr[i],newList);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];

        for(Map.Entry<Integer,List<Integer>> entry:indexMap.entrySet()){
            if(!used[entry.getValue().get(0)]){
                int diff = s-entry.getKey();//otherNumber of pair
                if(indexMap.containsKey(diff) && !used[indexMap.get(diff).get(0)]){
                    for(int i:entry.getValue()){
                        used[i] = true;
                    }

                    for(int i:indexMap.get(diff)){
                        used[i] = true;
                    }

                    for(int i:entry.getValue()){
                        for(int j:indexMap.get(diff)){
                            if(i<j){
                                List<Integer> newList = List.of(arr[i],arr[j]);
                                result.add(newList);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] input1 = {1,2,3,4,5};
        int s1 = 5;

        int[] input2 = {2,-3,3,3,-2};
        int s2 = 0;

        int[] input3 = {2,-6,2,2,5};
        int s3 = 4;

        PairSumWithSumKDuplicates obj = new PairSumWithSumKDuplicates();

        List<List<Integer>> l= obj.pairSum(input1,s1);
        System.out.println("**********");
        for(List<Integer> lt:l){
            System.out.println(lt);
        }

        List<List<Integer>> l2= obj.pairSum(input2,s2);
        System.out.println("**********");
        for(List<Integer> l2t:l2){
            System.out.println(l2t);
        }

        List<List<Integer>> l3= obj.pairSum(input3,s3);
        System.out.println("**********");
        for(List<Integer> l3t:l3){
            System.out.println(l3t);
        }
    }

}
