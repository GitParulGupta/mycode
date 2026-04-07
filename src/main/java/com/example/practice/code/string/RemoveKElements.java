package com.example.practice.code.string;

import java.util.Stack;

public class RemoveKElements {

    public static String removeKDigits(String num, int k) {

        Stack<Integer> st = new Stack<Integer>();

        char[] charArray = num.toCharArray();

        //st.push(Integer.valueOf(charArray[0]));

        int numRemoved = 0;
        for(int i=0;i<charArray.length;i++){
            if(numRemoved<k && !st.isEmpty() && Integer.valueOf(charArray[i])<st.peek()){
                st.pop();
                numRemoved++;
            }
            st.push(Integer.valueOf(charArray[i]));
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            int i = st.pop();
            sb.append(i);
        }
        sb.reverse();

        return sb.toString();

    }
}
