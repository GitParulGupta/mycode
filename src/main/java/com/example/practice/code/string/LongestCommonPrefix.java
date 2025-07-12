package com.example.practice.code.string;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    public String solution(String[] strs){
        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        int i=0; int k=0;
        StringBuilder curPrefix = new StringBuilder();

        while(i<first.length && k<last.length){
            if(first[i]!=last[k]){
                break;
            }
            curPrefix.append(first[i]);
            i++;
            k++;
        }

        return curPrefix.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        LongestCommonPrefix lcb = new LongestCommonPrefix();
        System.out.println(lcb.solution(strs));
    }

}
