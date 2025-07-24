package com.example.practice.code.heap;

import java.util.*;

/**
 * Given an array and a number X and a number k, find K such numbers which are closest to X.
 */
public class KClosestNumbers {

    /**
     * create an array. Subtract 7 from each element and find closes element with minimum difference
     */
    public void solution1(int[] ar, int k, int x){
        int[] ar2 = new int[ar.length];

        int i = 0;
        for(int j:ar){
            ar2[i] = Math.abs(j-x);
            i++;
        }

        Arrays.sort(ar2);
        Set<Integer> st = new HashSet<>();
        for(int m=0;m<k;m++){
            st.add(ar2[m]);
        }

        List<Integer> result = new ArrayList<>();
        for (int j : ar) {
            if (result.size() < k && st.contains(Math.abs(j-x))) {
                result.add(j);
            }
        }
        result.forEach(System.out::print);
    }

    /**
     * Sort the abs differences using heap by adding pair of abs diff and number to heap
     * @param ar
     * @param k
     * @param x
     */
    public void solutionHeap(int[] ar, int k, int x){

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.getDiff()-o1.getDiff();
            }
        });

        for(int i: ar){
            maxHeap.add(new Pair(i,Math.abs(i-x)));
            while (maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            result.add(maxHeap.poll().getValue());
        }
        result.forEach(System.out::print);

    }

    public static void main(String[] args) {
        int[] input = {5,6,7,8,2};

        KClosestNumbers obj = new KClosestNumbers();
        obj.solution1(input,3,7);

        obj.solutionHeap(input,3,7);
    }

}

class Pair{
    private int value;
    private int diff;

    Pair(int value, int min){
        this.value = value;
        this.diff = min;
    }

    public int getValue() {
        return value;
    }

    public int getDiff() {
        return diff;
    }
}
