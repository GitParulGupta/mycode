package com.example.practice.code.stackandqueues;

import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {

        int i=0;

        Stack<Character> st = new Stack<>();

        while(i<s.length()){

            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else{

                char current = s.charAt(i);
                if(st.isEmpty()){
                    return false;
                }
                char currentTop = st.pop();
                if(currentTop=='{' && (current == ')' || current == ']' )){
                    return false;
                }else if(currentTop=='[' && (current == ')' || current == '}' )){
                    return false;
                }else if(currentTop=='(' && (current == '}' || current == ']' )){
                    return false;
                }
            }
            i++;

        }

        return st.isEmpty();

    }

    public boolean isValidOption2(String s) {

        Stack<Character> st = new Stack<>();

        int i = 0;

        while(i<s.length()){

            if (s.charAt(i)=='(' || s.charAt(i)=='{'||s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')' && !st.isEmpty() && st.peek()=='('){
                st.pop();
            }else if(s.charAt(i)=='}' && !st.isEmpty() && st.peek()=='{'){
                st.pop();
            }else if(s.charAt(i)==']' && !st.isEmpty() && st.peek()=='['){
                st.pop();
            }else{
                return false;
            }
            i++;
        }

        return st.isEmpty();

    }

    public static void main(String[] args) {
        ValidParanthesis obj = new ValidParanthesis();
        System.out.println(obj.isValid("[(])"));

        System.out.println(obj.isValidOption2("()"));
    }
}
