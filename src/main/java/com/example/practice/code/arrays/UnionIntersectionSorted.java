package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given 2 sorted arrays, find the resultant array with elements containing union of 2 arrays. Union is all unique elements in both arrays in sorted order
 * a1 = {1,2,2,3,3,4,5,6}
 * a2 = {2,3,3,5,6,6,7}
 * result = {1,2,3,4,5,6,7}
 *
 * Given 2 sorted arrays, find the resultant array with elements containing intersection of 2 arrays. Intersection is all elements common in both arrays in sorted order
 * a1 = {1,2,2,3,3,4,5,6}
 * a2 = {2,3,3,5,6,6,7}
 * result = {2,3,5,6}
 */
public class UnionIntersectionSorted {

    private void addElement(List<Integer> l, int n){
        if(l.isEmpty()){
            l.add(n);
        }else{
            if(l.getLast()!=n){
                l.add(n);
            }
        }
    }

    public List<Integer> union(int[] a1, int[] a2){
        List<Integer> union = new ArrayList<>();

        int n1 = a1.length;
        int n2 = a2.length;
        int i =0;
        int j=0;
        while (i<n1 && j<n2){
            if(a1[i]<a2[j]){
                addElement(union,a1[i]);
                i++;
            }else if(a1[i]==a2[j]){
                addElement(union,a1[i]);
                i++;
                j++;
            }else{
                addElement(union,a2[j]);
                j++;
            }
        }

        while(i<n1){
            addElement(union,a1[i]);
            i++;
        }
        while(j<n2){
            addElement(union,a2[j]);
            j++;
        }
        return union;

    }


    public List<Integer> intersection(int[] a1, int[] a2){
        List<Integer> intersection = new ArrayList<>();

        int n1 = a1.length;
        int n2 = a2.length;
        int i =0;
        int j=0;
        while (i<n1 && j<n2){
            if(a1[i]<a2[j]){
                i++;
            }else if(a1[i]==a2[j]){
                intersection.add(a1[i]);
                i++;
                j++;
            }else{
                j++;
            }
        }

        return intersection;

    }

    public static void main(String[] args) {
        int[] a1 = {1,2,2,3,3,4,5,6};
        int[] a2 = {2,3,3,5,6,6,7};
        UnionIntersectionSorted obj = new UnionIntersectionSorted();
        List<Integer> resultUnion = obj.union(a1,a2);
        System.out.println("Union: "+resultUnion);
        List<Integer> resultIntersection = obj.intersection(a1,a2);
        System.out.println("Intersection: "+resultIntersection);
    }
}
