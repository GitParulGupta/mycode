package com.example.practice.code.stackandqueues;

import java.util.Stack;

/**
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * Constraints:
 * 1 <= k <= num.length <= 105
 * num consists of only digits.
 * num does not have any leading zeros except for the zero itself.
 */
public class RemoveKDigits {

    public String solution(String num, int k){
        Stack<Character> st = new Stack<>();

        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && k>0 && st.peek()-'0'>num.charAt(i)-'0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(k>0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";
        else {
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }

            sb.reverse();

            String result = sb.toString();
            int i=0;
            if(!result.isEmpty()){

                while(i<result.length() && result.charAt(i)=='0'){
                    i++;
                }
            }

            if(result.substring(i).isEmpty()) return "0";
            return result.substring(i);
        }
    }

    public static void main(String[] args) {
        RemoveKDigits obj = new RemoveKDigits();
        String num = "1432219"; int k = 3;
        System.out.println("Input String: "+num+" k: "+k+" result: "+ obj.solution(num,k));

        String num2 = "10200"; int k2 = 1;
        System.out.println("Input String: "+num2+" k: "+k2+" result: "+ obj.solution(num2,k2));
    }

}
