package com.example.practice.code.string;

/**
 * You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
 * A substring is a contiguous sequence of characters within a string.
 */
public class MaxOddNumber {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--){
            if(Integer.parseInt(""+num.charAt(i))%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String i ="52";
        String i1 ="34527";
        MaxOddNumber maxOddNumber = new MaxOddNumber();
        System.out.println(maxOddNumber.largestOddNumber(i));
        System.out.println(maxOddNumber.largestOddNumber(i1));
    }
}
