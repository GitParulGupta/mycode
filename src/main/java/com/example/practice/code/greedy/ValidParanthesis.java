package com.example.practice.code.greedy;

/**
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 * The following rules define a valid string:
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 * Example 1:
 * Input: s = "()"
 * Output: true
 * Example 2:
 * Input: s = "(*)"
 * Output: true
 */
public class ValidParanthesis {

    //Check all possible solutions
    //TC: 3^N --> 3 branches
    public boolean solutionBruteForce(String s){

        int index = 0;
        int count= 0;
        return bruteForceHelper(s,index,count);

    }

    private boolean bruteForceHelper(String s, int index, int count){
        if(count<0){
            return false;
        }
        if(index==s.length()){
            return count==0;
        }
        if(s.charAt(index)=='('){
            return bruteForceHelper(s,index+1,count+1);
        }else if(s.charAt(index)==')'){
            return bruteForceHelper(s,index+1,count-1);
        }else{
            return bruteForceHelper(s,index+1,count+1) || bruteForceHelper(s,index+1,count-1) || bruteForceHelper(s,index+1,count);
        }
    }

    //DP
    //O(N^2)
    public boolean betterSolution(String s){
        return false;
    }

    //https://www.youtube.com/watch?v=cHT6sG_hUZI
    public boolean optimalSolution(String s){
        return true;
    }

    public static void main(String[] args) {
        String s = "(*()";

        ValidParanthesis obj = new ValidParanthesis();
        System.out.println(obj.solutionBruteForce(s));

    }
}
