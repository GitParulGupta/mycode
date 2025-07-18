package com.example.practice.code.slidingWindow;

import java.util.HashMap;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exist other ways to achieve this answer too.
 */
public class LongestRepeatingCharacterReplacement {

    /**
     * In this approach, we generate all the arrays and check if the number of changes <= length of string - maximumFrequencyCharacter
     * @param s
     * @param k
     */
    public int solutionBruteForce(String s, int k){
        int maxLen = 0;

        for(int i=0;i<s.length();i++){
            int[] hash = new int[26];

            int maxFreq = 0;

            for(int j=i;j<s.length();j++){
                hash[s.charAt(j)-'A']+=1;
                maxFreq = Math.max(maxFreq,hash[s.charAt(j)-'A']);

                int changes = (j-i+1)-maxFreq;

                if(changes<=k){
                    maxLen =Math.max(maxLen,j-i+1);
                }else{
                    break;
                }
            }

        }

        return maxLen;
    }


    public int solutionOptimal(String s, int k){
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int maxFreq = 0;

        HashMap<Character,Integer> charMap = new HashMap<>();

        while(j<s.length()){

            charMap.put(s.charAt(j),charMap.getOrDefault(s.charAt(j),0)+1);

            maxFreq = Math.max(maxFreq,charMap.get(s.charAt(j)));

            while(j-i+1-maxFreq>k){
                if(charMap.containsKey(s.charAt(i)) && charMap.get(s.charAt(i))>1){
                    charMap.put(s.charAt(i),charMap.get(s.charAt(i))-1);
                }else{
                    charMap.remove(s.charAt(i));
                }
                /*if(charMap.containsKey(s.charAt(i))){
                    maxFreq = Math.max(maxFreq,charMap.get(s.charAt(i)));
                }*///Not needed as we are trimming down the space.
                i++;
            }

            maxLen = Math.max(maxLen,j-i+1);
            j++;

        }

        return maxLen;
    }
    //These 2 solutions give time complexity O(2N)x26 where N is for outer loop and N is for inner loop
    public int solutionOptimalHashArray(String s, int k){
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int maxFreq = 0;

        int[] hash = new int[26];

        while(j<s.length()){

            hash[s.charAt(j)-'A']++;

            maxFreq = Math.max(maxFreq,hash[s.charAt(j)-'A']);

            while(j-i+1-maxFreq>k){
                hash[s.charAt(i)-'A']--;
                i++;
            }

            maxLen = Math.max(maxLen,j-i+1);
            j++;

        }

        return maxLen;
    }

    //TC --> O(N)x26 ~ O(N)
    public int solutionBest(String s, int k){
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int maxFreq = 0;

        int[] hash = new int[26];

        while(j<s.length()){

            hash[s.charAt(j)-'A']++;

            maxFreq = Math.max(maxFreq,hash[s.charAt(j)-'A']);
            //rather than removing all invalid chars in begin we fix the window size and help will decrease the TC
            if(j-i+1-maxFreq>k){
                hash[s.charAt(i)-'A']--;
                i++;
            }

            maxLen = Math.max(maxLen,j-i+1);
            j++;

        }

        return maxLen;
    }


    public static void main(String[] args) {

        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();

        String s1 = "AABABBA";
        int k1 = 2;

        System.out.println("String: "+s1+" k:"+k1+" length:"+obj.solutionBruteForce(s1,k1));
        System.out.println("String: "+s1+" k:"+k1+" length:"+obj.solutionOptimal(s1,k1));
        System.out.println("String: "+s1+" k:"+k1+" length:"+obj.solutionOptimalHashArray(s1,k1));

    }

}
