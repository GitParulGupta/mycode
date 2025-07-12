package com.example.practice.code.arrays;

/**
 * Given a sorted array, return the element which occurs only once. Other elements appear atleast twice
 * a = {1,1,2,3,3,4,4,4}
 * Brute force --> for every number, check if it appears again
 * Better --> HashMap --> for integer and its frequency but extra space will be used.
 * Optimal solution - iteration
 */
public class OneOccurrence {

    public int solution(int[] a){

        if(a.length==1){
            return a[0];
        }
        if(a[0]!=a[1]){
            return a[0];
        }
        if(a[a.length-1]!=a[a.length-2]){
            return a[a.length-1];
        }

        int i = 1;

        while(i<a.length-1){
            if(a[i]!=a[i-1] && a[i]!=a[i+1]){
                return a[i];
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3,3,4,4,4};
        int[] a2 = {1};
        int[] a3 = {1,2,2};
        int[] a4 = {1,1,2};
        int[] a5 = {1,1,2,2,3,3,4,4,4};
        OneOccurrence obj = new OneOccurrence();
        System.out.println(obj.solution(a));
        System.out.println(obj.solution(a2));
        System.out.println(obj.solution(a3));
        System.out.println(obj.solution(a4));
        System.out.println(obj.solution(a5));
    }
}
