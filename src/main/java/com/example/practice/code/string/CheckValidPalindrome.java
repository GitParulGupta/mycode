package com.example.practice.code.string;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class CheckValidPalindrome {

    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        int i=0;

        while(i<s.length()){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z')|| (s.charAt(i)>='0' && s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
            i++;
        }

        String newS = sb.toString().toLowerCase();
        if(newS.isEmpty()){
            return true;
        }
        String reverseNewS = sb.reverse().toString().toLowerCase();

        if(newS.equals(reverseNewS)){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        String s = "0P";
        CheckValidPalindrome obj = new CheckValidPalindrome();
        System.out.println(obj.isPalindrome(s));
    }

}
