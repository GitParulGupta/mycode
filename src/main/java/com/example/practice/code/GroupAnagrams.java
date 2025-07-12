package com.example.practice.code;

import lombok.Builder;
import lombok.Value;

import java.util.*;

/**
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 * Example 1:
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 * Example 2:
 * Input: strs = ["x"]
 * Output: [["x"]]
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,Member> stringElementMap = generateElementMap(strs);

        Set<String> sortedStringSet = new HashSet<>();

        for(Member m: stringElementMap.values()){
            sortedStringSet.add(m.sortedString());
        }

        HashMap<String,List<String>> resultMap = new HashMap<>();

        for(String c:sortedStringSet){
            resultMap.put(c,new ArrayList<>());
        }

        for(Map.Entry<String,Member> entry:stringElementMap.entrySet()){

            String sortedString = entry.getValue().sortedString();
            int counts = entry.getValue().count();
            String key = entry.getKey();

            List<String> currentList = resultMap.get(sortedString);

            for(int i=0;i<counts;i++){
                currentList.add(key);
            }

            resultMap.put(sortedString,currentList);
        }

        return resultMap.values().stream().toList();

    }

    private HashMap<String,Member> generateElementMap(String[] strs){
        HashMap<String,Member> stringElementMap = new HashMap<>();

        for (String str : strs) {

            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            if (stringElementMap.containsKey(str)) {
                int currentCount = stringElementMap.get(str).count();
                Member newMember = new Member(new String(charArray),currentCount+1);
                stringElementMap.put(str, newMember);
            } else {
                Member newMember = new Member(new String(charArray),1);
                stringElementMap.put(str, newMember);
            }
        }
        return stringElementMap;
    }

    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat","hat",""};
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.groupAnagrams(strs));
    }
}

record Member(String sortedString, int count) {
}
