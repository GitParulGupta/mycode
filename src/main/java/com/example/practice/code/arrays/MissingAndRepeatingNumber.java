package com.example.practice.code.arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array which contains elements from 1->n, return pairs of numbers st {repeatingNumber, missingNumber}
 * Example: n =6 , a = {4,2,6,3,1,1}
 * n>1
 * ans: {1,5}
 */
public class MissingAndRepeatingNumber {

    public int[] bruteForceSolution(int[] a, int n){

        int missing = 0;
        int repeating = 0;

        Arrays.sort(a);

        Map<Integer,Integer> m= new HashMap<>();

        for(int i:a){
            m.put(i, m.getOrDefault(i,0)+1);
        }

        for(int i=1;i<=n;i++){
            if(m.containsKey(i) && m.get(i)>1){
                repeating = i;
            }else if(!m.containsKey(i)){
                missing = i;
            }
        }
        return new int[]{repeating,missing};

    }

    public int[] betterUsingHashing(int[] a){
        int n = a.length;

        int[] hashArray = new int[n+1];

        for(int i:a){
            hashArray[i]=hashArray[i]+1;
        }

        int missing = 0;
        int repeating  =0;

        for(int i=1;i<hashArray.length;i++){
            if(hashArray[i]>1){
                repeating = i;
            }
            if(hashArray[i]==0){
                missing = i;
            }
        }

        return new int[]{repeating,missing};

    }

    public long[] optimalSolution(int[] a){
        int n = a.length;

        long s = 0; //sum of array elements

        for(int i:a){
            s=s+i;
        }

        long sn = (long)n*(n+1)/2; //sum of first n natural numbers

        long s1 = 0; //sum of squares of array elements

        for(int i:a){
            s1= (long) (s1+Math.pow(i,2));
        }

        long sn1 = (long)n*(n+1)*(2L*n+1)/6; // sum of squares of first n natural numbers

        //2 expressions s-sn & s1^2 - s1n^2
        //2 expressions s-sn & (s1- s1n)(s1+ s1n)

        long diff = s-sn; //x-y
        long diff1 = s1 - sn1; //x+y
        diff1=diff1/diff;

        long repeating =  (diff+diff1)/2;

        long missing = repeating-diff;

        return new long[]{repeating,missing};
    }

    public static void main(String[] args) {
        int[] input = {4,3,6,2,1,1};

        MissingAndRepeatingNumber obj = new MissingAndRepeatingNumber();
        System.out.println("BruteForce: "+Arrays.toString(obj.bruteForceSolution(input,6)));

        System.out.println("BetterUsingHashing: "+Arrays.toString(obj.betterUsingHashing(input)));
        System.out.println("Optimal solution: "+Arrays.toString(obj.optimalSolution(input)));
    }

}
