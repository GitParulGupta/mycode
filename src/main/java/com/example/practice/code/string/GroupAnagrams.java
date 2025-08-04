package com.example.practice.code.string;


import ch.qos.logback.core.joran.sanity.Pair;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagrams {

    public List<List<String>> solution(String[] input){

        List<WordPair> pairList = new ArrayList<>();

        for(String s:input){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String srotedString = new String(c);
            WordPair p= new WordPair(s,srotedString);
            pairList.add(p);
        }

        Map<String,List<String>> resultMap = new HashMap<>();

        for(WordPair p:pairList){
            if(resultMap.containsKey(p.sortedWord())){
                List<String> temp = new ArrayList<>(resultMap.get(p.originalWord()));
                temp.add(p.originalWord());
                resultMap.put(p.sortedWord(),temp);
            }else{
                resultMap.put(p.sortedWord(),List.of(p.originalWord()));
            }
        }

        return resultMap.values().stream().toList();

    }

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};

        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> ans = obj.solution(input);

        for(List<String> l:ans){
            for(String s: l){
                System.out.print(s+" ");
            }
            System.out.print("\n");
        }
    }

}


record WordPair(String originalWord, String sortedWord){
}
