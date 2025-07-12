package com.example.practice.code.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesII {

    public int solution(int[] nums){

        LinkedHashMap<Integer,Integer> elementCountMap = new LinkedHashMap<>();

        for(int i:nums){
            if(elementCountMap.containsKey(i)){
                elementCountMap.compute(i, (k, n) -> n + 1);
            }else{
                elementCountMap.put(i,1);
            }
        }

        int i=0;

        for(Map.Entry<Integer,Integer> entry:elementCountMap.entrySet()){
            if(entry.getValue()<2){
                nums[i] = entry.getKey();
                i++;
            } else {
                nums[i] = entry.getKey();
                nums[i+1]=nums[i];
                i=i+2;
            }
        }

        int maxArrayElement = nums[nums.length-1];

        int returnedIndex = -1;
        for(int j=0;j<nums.length;j++){
            if(nums[j]==maxArrayElement && elementCountMap.get(maxArrayElement)>1){
                returnedIndex = j+1;
                break;
            }else if(nums[j]==maxArrayElement && elementCountMap.get(maxArrayElement)==1){
                returnedIndex = j;
                break;
            }
        }
        System.out.println(Arrays.toString(nums));

        return returnedIndex+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesII rm2 = new RemoveDuplicatesII();
        System.out.println(rm2.solution(nums));
    }

}
