package com.example.practice.code;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        String[] wordsArray = s.split(" ");

        StringBuilder original = new StringBuilder();

        for(String s2:wordsArray){
            original.append(s2);
        }

        String originalString = original.toString().toLowerCase();
        System.out.println("Original String: "+originalString);

        int i=0;
        int j= originalString.length()-1;
        boolean matches = true;
        while(i<=j && matches){
            if(!Character.isLetterOrDigit(originalString.charAt(i))){
                i++;
            }
            if(!Character.isLetterOrDigit(originalString.charAt(j))){
                j--;
            }
            if(originalString.charAt(i)!=originalString.charAt(j)){
                matches = false;
            }
            i++;
            j--;
        }
        return matches;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String input = "Madam, in Eden, I'm Adam";//"Was it a car or a cat I saw?";
        System.out.println("Result:"+vp.isPalindrome(input));
    }
}
