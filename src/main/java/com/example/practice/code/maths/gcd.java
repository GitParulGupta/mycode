package com.example.practice.code.maths;


/**
 * CGD/HCF - Greatest common divisor for 2 given numbers
 */
public class gcd {

    //TC is O(min(n1,n2)) for worst case. say n1 is 11 and n2 is 13 --> GCD is 1
    public int solution(int n1, int n2){

        for(int i=Math.min(n1,n2);i>=1;i--){
            if(n1%i==0 && n2%i==0){
                return i;
            }
        }
        return 0;
    }

    //Euclidien algorithm
    public int solitionOptimal(int n1, int n2){
        while(n1>0 && n2>0){
            if(n1>n2) n1 = n1%n2;
            else n2=n2%n1;
        }

        if(n1==0) return n2;
        else return n1;
    }

}
