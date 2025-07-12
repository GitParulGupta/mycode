package com.example.practice.code.arrays;

import java.util.*;

/**
 * Google
 * Given an array, find all possible set of distinct there number pairs from array which sum upto 0 s.t.
 * a[i]+a[j]+a[k]=0 && i!=j!=k
 */
public class ThreeSum {

    public void bruteForce(int[] a){

        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0;i<a.length-2;i++){
            for(int j=i+1;j<a.length-1;j++){
                for(int k=j+1;j<a.length;j++){
                    if(a[i]+a[j]+a[k]==0){
                        List<Integer> temp= new ArrayList<>(List.of(a[i], a[j], a[k]));
                        temp.sort(Comparator.naturalOrder());
                        ans.add(temp);
                    }
                }
            }
        }
        print(ans);
    }

    public void betterSolution(int[] a){

        //a[i]+a[j]=-a[k] or -(a[i]+a[j])=a[k]
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> temp = new HashSet<>();

        for(int i=0;i<a.length-1;i++){
            temp = new HashSet<>();
            for(int j=i+1;j<a.length;j++){
                int third = -(a[i]+a[j]);
                if(temp.contains(third)){
                    List<Integer> tempAns= new ArrayList<>(List.of(a[i], a[j], third));
                    tempAns.sort(Comparator.naturalOrder());
                    ans.add(tempAns);
                }
                temp.add(a[j]);
            }
        }
        print(ans);

    }

    public void optimalSolution(int[] a){
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(a); //nlogn
        for(int i=0;i<a.length-1;i++){
            if(i>0 && a[i]==a[i-1]) continue;
            int j=i+1; int k=a.length-1;

            while (j<k){
                int sum = a[i]+a[j]+a[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer> tempAns= new ArrayList<>(List.of(a[i], a[j], a[k]));
                    ans.add(tempAns);
                    j++;
                    k--;
                    while(j<k && a[j]==a[j-1])j++;
                    while(j<k && a[k]==a[j+1])k++;
                }
            }

        }
        print(ans);
    }

    public void print(Set<List<Integer>> s){
        for(List<Integer> l:s){
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        int[] a = {-2,-2,-2,0,1,2,1,1,1,2,0,2,2,0};

        ThreeSum obj = new ThreeSum();
        System.out.println("Brute force");
        obj.bruteForce(a);
        System.out.println("Better solution");
        obj.betterSolution(a);
        System.out.println("Optimal solution");
        obj.optimalSolution(a);

    }

}
