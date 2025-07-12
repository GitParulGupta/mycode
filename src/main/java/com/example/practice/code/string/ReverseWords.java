package com.example.practice.code.string;

/**
 * Given a string, reverse the words of the string. Remove leading & trailing spaces. Remove spaces in between
 */
public class ReverseWords {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();

        String[] wordArray = s.split(" ");

        for(int i=wordArray.length-1;i>=0;i--){
            if(wordArray[i].isEmpty())continue;
            sb.append(wordArray[i].trim()).append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String i = " a good  example";
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWords(i));
    }
}
