package com.example.practice.code.string;

import java.util.HashSet;
import java.util.Set;

/**
 * You have been given an Encrypted String where repetitions of substrings are represented as substring followed by the count of substrings.
 * Example: String "aabbbcdcdcd" will be encrypted as "a2b3cd3".
 * You need to decrypt the given string
 * Note :
 * Input string will always be lowercase characters without any spaces.
 * If the count of a substring is 1 then also it will be followed by Integer '1'.
 * Example: "aabcdee" will be Encrypted as "a2bcd1e2"
 * This means it's guaranteed that each substring is followed by some Integer.
 * Also, the frequency of encrypted substring can be of more than one digit. For example, in "ab12c3", ab is repeated 12 times. No leading 0 is present in the frequency of substring.
 * The frequency of a repeated substring can also be in parts.
 * Example: "aaaabbbb" can also have "a2a2b3b1" as Encrypted String.
 */
public class DecryptString {

    public String solution(String s){

        Set<Character> numSet =  new HashSet<>();
        for(int i=0;i<=9;i++){
            numSet.add((char) ('0'+i));
        }

        int i=0; int j = 0; int k= 0;

        StringBuilder sb = new StringBuilder();

        while(i<s.length() && j<s.length() && k<s.length()){

            if(numSet.contains(s.charAt(j))){

                k=j;

                while(numSet.contains(s.charAt(k))){
                    k++;
                }

                int freq = Integer.valueOf(s.substring(j,k));

                String curSubString = s.substring(i,j);

                int count=1;
                while(count<=freq){
                    sb.append(curSubString);
                    count++;
                }

                i=k;
                j=i;
            }else{
                j++;
            }

        }

        int freq = Integer.valueOf(s.substring(j,k));

        String curSubString = s.substring(i,j);

        int count=1;
        while(count<=freq){
            sb.append(curSubString);
            count++;
        }

        return sb.toString();

    }


    public static void main(String[] args) {
        String input1 = "a2bc3d1e3";

        String input2 = "aa22bc3d1e3";

        DecryptString obj = new DecryptString();
        System.out.println(obj.solution(input1));
    }

}
