package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You have been given an integer array/list(arr) and a number 'Sum'. Find and return the total number of pairs in the array/list which when added, results equal to the 'Sum'.
 * Note:
 * Given array/list can contain duplicate elements.
 *
 * (arr[i],arr[j]) and (arr[j],arr[i]) are considered same.
 */
public class PairsWithSumK {

    public static int pairsWithGivenSum(int[] ar, int target){

        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for(int i=0;i<ar.length;i++){
            if(indexMap.containsKey(ar[i])){
                List<Integer> l = indexMap.get(ar[i]);
                l.add(i);
                indexMap.put(ar[i],l);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(i);
                indexMap.put(ar[i],l);
            }
        }

        boolean[] vis = new boolean[ar.length];

        int count = 0;

        for(int i=0;i<ar.length;i++){

            if(!vis[i]){
                int offset = target-ar[i];

                if(ar[i]!=offset){
                    if(indexMap.containsKey(offset)){

                        if(!vis[indexMap.get(offset).get(0)]){
                            List<Integer> l1 = indexMap.get(ar[i]);
                            List<Integer> l2 = indexMap.get(offset);

                            count+= (l1.size()*l2.size());

                            for(int k:l1){
                                vis[k] = true;
                            }
                            for(int k:l2){
                                vis[k] = true;
                            }
                        }
                    }
                }else{
                    List<Integer> l1 = indexMap.get(ar[i]);
                    int n1 = l1.size();
                    count+= n1*(n1-1)/2;
                    for(int k:l1){
                        vis[k] = true;
                    }
                }

            }

        }
        return count;

    }

}
