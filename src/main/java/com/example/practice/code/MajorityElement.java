package com.example.practice.code;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

    public int solutionWithExtraSpace(int[] nums){

        int minExpectedElementCount = Math.round((float) nums.length /2);

        HashMap<Integer,Integer> elementCountMap = new HashMap<>();

        for(int i:nums){
            if(elementCountMap.containsKey(i)){
                elementCountMap.compute(i, (k, n) -> n + 1);
            }else{
                elementCountMap.put(i,1);
            }
        }

        for(Map.Entry<Integer,Integer> m : elementCountMap.entrySet()){
            if(m.getValue()>=minExpectedElementCount){
                return m.getKey();
            }
        }
        return -1;
    }

    public int SolutionWithoutExtraSpace(int[] nums){

        if(nums.length==1){
            return nums[0];
        }

        Arrays.sort(nums);

        int minExpectedElementCount = Math.round((float) nums.length /2);

        int currentElement = nums[0];
        int currentElementCount = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==currentElement){
                currentElementCount ++;
                if(currentElementCount>=minExpectedElementCount)
                    return currentElement;
            }else{
                currentElement = nums[i];
                currentElementCount = 1;
            }
        }
        return currentElement;
    }

    public static void main(String[] args) {
        int[]  nums = {2,2,1,1,1,2,2};
        MajorityElement me = new MajorityElement();
        System.out.println("Result with extra space:"+me.solutionWithExtraSpace(nums));
        System.out.println("Result without extra space:"+me.SolutionWithoutExtraSpace(nums));
    }

}
