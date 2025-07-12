package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Majority element is the element which appears more than n/2 times
 * Given an array, find the majority element if it exists else return -1
 *
 * Brute force: Double loop and check for frequency of each element
 * Better solution : create hasmap with element and frequency
 * Optimal : Moore's voting algo
 *
 * 1. Moore's voting algo
 * 2. Fetch count of element from array received in step 1
 * 3. verify if majority element condition is satisfied
 *
 */
public class MajorityElement {

    public int solution(int[] a){
        int el=0;
        int count=0;
        for(int i=0;i<a.length;i++){
            if(count==0){
                el = a[i];
                count++;
            }else if(a[i]==el){
                count++;
            }else{
                count--;
            }
        }

        int count1 = 0;
        for(int i:a){
            if(i==el){
                count1++;
            }
        }

        if(count1>(a.length/2)){
            return el;
        }
        return -1;
    }

    /**
     * Extending current problem to n/3 times i.e. find majority element tht occurs more than n/3 times
     * if n/3 then at max we can have 2 elements
     * @param a
     * @return
     */
    public List<Integer> solutionMajority3(int[] a){
        int el1=0;
        int el2=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<a.length;i++){
            if(count1==0 && a[i]!=el2){
                el1 = a[i];
                count1++;
            }else if(count2==0 && a[i]!=el1){
                el2 = a[i];
                count2++;
            }else if(a[i]==el1){
                count1++;
            }else if(a[i]==el2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        int countEl1 = 0; int countEl2=0;
        for(int i:a){
            if(i==el1){
                countEl1++;
            }else if(i==el2){
                countEl2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        if(countEl1>(a.length/3) ){
            result.add(el1);
        }
        if(countEl2>(a.length/3) ){
            result.add(el2);
        }
        return result;
    }

    public static void main(String[] args) {

        MajorityElement obj = new MajorityElement();

        int[] a = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        System.out.println(obj.solution(a));
        System.out.println("For n/3:"+obj.solutionMajority3(a));

        int[] a1 = {0,1,2,0,1,2,1,2,0,0,0,1};
        System.out.println(obj.solution(a1));
        System.out.println("For n/3:"+obj.solutionMajority3(a1));
    }

}
