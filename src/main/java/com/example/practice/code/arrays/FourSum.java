package com.example.practice.code.arrays;

import java.util.*;

/**
 * Google
 * Given an array, find all possible set of distinct four number pairs from array which sum upto 0 s.t.
 * a[i]+a[j]+a[k]+a[l]=0 && i!=j!=k!=l
 */
public class FourSum {

    public void bruteForce(int[] a){

        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0;i<a.length-3;i++){
            for(int j=i+1;j<a.length-2;j++){
                for(int k=j+1;k<a.length-1;k++){
                    for (int value : a) {
                        if (a[i] + a[j] + a[k] + value == 0) {
                            List<Integer> temp = new ArrayList<>(List.of(a[i], a[j], a[k], value));
                            temp.sort(Comparator.naturalOrder());
                            ans.add(temp);
                        }
                    }

                }
            }
        }
        print(ans);
    }

    public void betterSolution(int[] a){

        //a[i]+a[j]+a[k]=-a[l] or -(a[i]+a[j]+a[k])=a[l]
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> temp;

        for(int i=0;i<a.length-2;i++){
            for(int j=i+1;j<a.length-1;j++){
                temp = new HashSet<>();
                for (int k=j+1;k<a.length;k++) {
                    int fourth = -(a[i] + a[j] + a[k]);
                    if (temp.contains(fourth)) {
                        List<Integer> tempAns = new ArrayList<>(List.of(a[i], a[j], a[k], fourth));
                        tempAns.sort(Comparator.naturalOrder());
                        ans.add(tempAns);
                    }
                    temp.add(a[k]);
                }
            }
        }
        print(ans);

    }

    public void optimalSolution(int[] a){
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(a); //nlogn
        for(int i=0;i<a.length;i++){
            if(i>0 && a[i]==a[i-1]) continue;
            for(int j=i+1;j<a.length;j++){
                if(j!=i+1 && a[j]==a[j-1]) continue;
                int k=j+1; int l=a.length-1;

                while (k<l){
                    int sum = a[i]+a[j]+a[k]+a[l];
                    if(sum<0){
                        k++;
                    }else if(sum>0){
                        l--;
                    }else{
                        List<Integer> tempAns= new ArrayList<>(List.of(a[i], a[j], a[k],a[l]));
                        ans.add(tempAns);
                        k++;
                        l--;
                        while(k<l && a[k]==a[k-1])k++;
                        while(k<l && a[l]==a[l+1])l--;
                    }
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

        FourSum obj = new FourSum();
        System.out.println("Brute force");
        obj.bruteForce(a);
        System.out.println("Better solution");
        obj.betterSolution(a);
        System.out.println("Optimal solution");
        obj.optimalSolution(a);

    }

}
