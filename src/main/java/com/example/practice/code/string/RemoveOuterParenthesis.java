package com.example.practice.code.string;

public class RemoveOuterParenthesis {

    public String removeOuterParentheses(String s) {

        int i=0;
        int j =0;

        int openCount  = 0;
        StringBuilder sb = new StringBuilder();

        while(j<s.length()){
            if(s.charAt(j)=='('){
                openCount++;
            }else if(s.charAt(j)==')'){
                openCount--;
                if(openCount==0){
                    i++;
                    while(i<j){
                        sb.append(s.charAt(i));
                        i++;
                    }
                    i++;
                }
            }
            j++;
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        RemoveOuterParenthesis rb = new RemoveOuterParenthesis();
        String i1 = "(()())(())";
        System.out.println("For input"+i1+"Output: "+rb.removeOuterParentheses(i1));
    }
}
