package com.example.practice.code.slidingWindow;

import java.util.HashSet;
import java.util.Set;


/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * A substring is a contiguous sequence of characters within a string.
 * Example 1:
 * Input: s = "zxyzxyz"
 * Output: 3
 * Explanation: The string "xyz" is the longest without duplicate characters.
 * Example 2:
 * Input: s = "xxxx"
 * Output: 1
 * Example 3:
 * Input s = "dvdf"
 * Output: 1
 */
public class LongestSubStringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {

        if(s.length()<=1){
            return s.length();
        }

        Set<Character> charSet = new HashSet<>();

        int i = 0;
        int j = 0;
        int maxLen = 0;

        while(j<s.length()){
            if(charSet.contains(s.charAt(j))){
                while(charSet.contains(s.charAt(j))){
                    charSet.remove(s.charAt(i));
                    i++;
                }
            }
            int length = j-i+1;
            if(length>maxLen){
                maxLen = length;
            }

            charSet.add(s.charAt(j));
            j++;
        }

        return maxLen;

    }

}
