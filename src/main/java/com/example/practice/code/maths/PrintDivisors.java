package com.example.practice.code.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintDivisors {

    public List<Integer> divisors(int n){

        List<Integer> l = new ArrayList<>();

        for(int i=1;i<Math.sqrt(n);i++){

            if(n%i==0){
                l.add(i);
                if(n/i!=i){
                    l.add(n/i);
                }
            }

        }
        Collections.sort(l);
        return l;
    }

    public static void main(String[] args) {

        PrintDivisors obj = new PrintDivisors();

        obj.divisors(36).forEach(System.out::println);

    }

}
