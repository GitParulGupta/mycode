package com.example.practice.code.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a array, generate all the permutations of the array
 * Example: {1,2,3} --> {{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}}
 * Note number of permutations is n! where n is size of array
 */
public class GenerateArrayPermutations {

    public void generatePermutations(int[] arr){

        int n = arr.length;
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        generatePermutationHelper(n,arr, list,new ArrayList<>(),map);

        list.forEach(list1->{
            list1.forEach(i->System.out.print(i+","));
            System.out.println();
        });
    }

    private void generatePermutationHelper(int n, int[] arr, List<List<Integer>> result, List<Integer> temp, HashMap<Integer, Integer> map){

        if(temp.size() == n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
                temp.add(arr[i]);
                generatePermutationHelper(n, arr, result, temp, map);
                temp.remove(temp.size()-1);
                map.remove(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        GenerateArrayPermutations gap = new GenerateArrayPermutations();
        int[] arr = new int[]{1,2,3,4};
        gap.generatePermutations(arr);
    }

}
