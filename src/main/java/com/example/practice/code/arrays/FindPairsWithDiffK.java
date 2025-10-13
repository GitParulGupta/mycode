package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Problem statement
 * You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
 * Note: Take absolute difference between the elements of the array.
 *
 * Sample Input 1 :
 * 4
 * 5 1 2 4
 * 3
 * Sample Output 1 :
 * 2
 * Explanation
 * (5,2) and (1,4) are the possible combinations as their absolute difference is 3.
 * Sample Input 2 :
 * 4
 * 4 4 4 4
 * 0
 * Sample Output 2 :
 * 6
 */
public class FindPairsWithDiffK {

    public static int getPairsWithDifferenceK(int arr[], int k) {

        TreeMap<Integer, List<Integer>> indexMap = new TreeMap<>();

        for(int i=0;i<arr.length;i++){
            if(indexMap.containsKey(arr[i])){
                List<Integer> curList = new ArrayList<>();
                curList.addAll(indexMap.get(arr[i]));
                curList.add(i);
                indexMap.put(arr[i],curList);
            }else{
                indexMap.put(arr[i], List.of(i));//List.of creates unmodifiable lsit
            }

        }

        int pair = 0;

        for(Map.Entry<Integer,List<Integer>> e: indexMap.entrySet()){

            int key = e.getKey();
            int offset = key+k;

            if(indexMap.containsKey(offset)){
                List<Integer> index = indexMap.get(offset);
                if(index.size()>2){
                    int n = index.size();
                    pair += n*(n-1)/2;
                }else{
                    pair += index.size();
                }

            }

        }

        return pair;
    }

}
