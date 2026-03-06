package com.example.practice.code.blackrock;

/**
 * You are given a string 'S' of length 'N', you need to find the frequency of each of the characters from ‘a’ to ‘z’ in the given string.
 * Example :
 * Given 'S' : abcdg
 * Then output will be : 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 */
public class FrequencyOfCharactersOfString {

    public static int[] findFrequency(String S) {

        int[] result = new int[26]; //a-z;

        for(char c: S.toCharArray()){
            int index = c-'a';
            result[index] = result[index]+1;
        }

        return result;

    }
}
