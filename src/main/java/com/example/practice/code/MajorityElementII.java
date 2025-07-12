package com.example.practice.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer,Integer> numMap = new HashMap<>();

        int expectedCount = (int) (double) (nums.length / 3);

        for (int num : nums) {
            if (numMap.get(num) != null) {
                numMap.compute(num, (k, currentCount) -> currentCount + 1);
            } else {
                numMap.put(num, 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry:numMap.entrySet()){
            if(entry.getValue()>expectedCount){
                result.add(entry.getKey());
            }
        }

        return result;
    }

}
