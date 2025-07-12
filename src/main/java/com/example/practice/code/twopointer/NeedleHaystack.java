package com.example.practice.code.twopointer;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 */
public class NeedleHaystack {

    public int strStr(String haystack, String needle) {

        int left = 0;
        int right = needle.length();

        while(left<haystack.length() && right<haystack.length()){
            if(haystack.charAt(left)==needle.charAt(0)){
                String subString = haystack.substring(left,right);

                if(subString.equals(needle)){
                    return left;
                }

            }
            left++;
            right = left + needle.length();
        }

        return -1;

    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";

        NeedleHaystack nh = new NeedleHaystack();

        System.out.println(nh.strStr(haystack,needle));
    }

}
