package com.example.practice.code.maths;

/**
 * Number which has only 2 factors 1 and itself
 */
public class PrimeCheck {

    public boolean solution(int n){
        int count = 0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }

        if(count>2) return false;
        else return true;
    }

    public static void main(String[] args) {
        PrimeCheck obj= new PrimeCheck();
        System.out.println(obj.solution(45));
        System.out.println(obj.solution(31));
    }

}
