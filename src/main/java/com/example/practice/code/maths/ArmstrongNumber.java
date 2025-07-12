package com.example.practice.code.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer N, return true it is an Armstrong number otherwise return false.
 * An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
 *
 * n= 153
 * num digits =3
 * 1^3+3^3+5^3 = 153 therefore armstrong number
 */
public class ArmstrongNumber {

    public boolean solution(int n){
        int nCopy = n;
        List<Integer> l = new ArrayList<>();

        while(n>0){
            l.add(n%10);
            n=n/10;
        }

        int pow = l.size();

        int sumOfPowers = 0;

        for(int i:l){
            sumOfPowers = sumOfPowers + (int)Math.pow(i,pow);
        }

        if(nCopy==sumOfPowers)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        ArmstrongNumber obj= new ArmstrongNumber();
        System.out.println(obj.solution(153));
        System.out.println(obj.solution(125));
    }

}
