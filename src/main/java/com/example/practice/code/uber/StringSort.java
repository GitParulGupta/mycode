package com.example.practice.code.uber;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given string of words. You have to
 * i). Find the absolute difference of number of vowels & consonants in each word. ii). Sort words based on the absolute difference in
 * ascending order.
 * iii). If two words have the same diff, sort them alphabetically.
 *
 * String s = "apple bat code"
 *Result = code bat apple
 */
public class StringSort {

    public static void solve(String s){

        String[] input = s.trim().split(" ");

        List<WordInfo> wordInfoList = new ArrayList<>();

        for(String word: input){

            int vowels =0; int consonants = 0;

            for(char c: word.toLowerCase().toCharArray()){

                if("aeiou".indexOf(c)>=0){
                    vowels++;
                }else{
                    consonants++;
                }
            }

            int diff = Math.abs(vowels-consonants);

            WordInfo wordInfo = new WordInfo(word,diff);
            wordInfoList.add(wordInfo);
        }

        Collections.sort(wordInfoList, (a,b)->{
            if(a.diff!=b.diff){
                return a.diff-b.diff;
            }else{
                return a.word.compareTo(b.word);
            }
        });

        for(WordInfo word:wordInfoList){
            System.out.println(word.word);
        }
    }


    public static void main(String[] args) {
        String s = "apple bat code";

        StringSort.solve(s);
    }

}

class WordInfo{
    public String word;
    public int diff;
    public WordInfo(String word, int diff){
        this.word = word;
        this.diff = diff;
    }
}
