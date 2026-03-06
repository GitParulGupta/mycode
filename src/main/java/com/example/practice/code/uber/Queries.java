package com.example.practice.code.uber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a queries array which has numbers starting with +' or '-. You are also given an integer called diff'.
 * i). If a number is starting with '+' , you have to add them in array. One number can have multiple instances.
 * ii). If a number is starting with - you have to remove one instance of that number from array. The number will be present in array. iii). After each query,
 * find the number of pairs which have difference as 'diff & add this into an answer array. Answer array length would be equal to queries length.
 * Return the answer array.
 */
public class Queries {

    public static long[] solve(String[] s, int diff){

        //s = {"+1", "+5", "+3", "+4", "-5"} diff =2
        Map<Integer,Integer> freq = new HashMap<>();
        long pairCount =0;
        long[] ans = new long[s.length];

        for(int i=0;i<s.length;i++){
            char sign = s[i].charAt(0);
            int x = Integer.parseInt(s[i].substring(1));

            if(sign=='+'){
                pairCount += freq.getOrDefault(x-diff,0);
                pairCount += freq.getOrDefault(x+diff,0);
                freq.put(x,freq.getOrDefault(x,0)+1);
            }else if(sign=='-'){
                pairCount -= freq.getOrDefault(x-diff,0);
                pairCount -= freq.getOrDefault(x+diff,0);

                if(freq.get(x)==1){
                    freq.remove(x);
                }else{
                    freq.put(x,freq.get(x)-1);
                }
            }
            ans[i]=pairCount;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"+1", "+5", "+3", "+4", "-5"};
        int diff = 2;

        System.out.println(Arrays.toString(Queries.solve(s, diff)));

    }

}
