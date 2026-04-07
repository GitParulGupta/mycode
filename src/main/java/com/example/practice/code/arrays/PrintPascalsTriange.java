package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it
 */
public class PrintPascalsTriange {

    public List<List<Integer>> generate(int numRows) {

        int k = 0; List<List<Integer>> r = new ArrayList<>();

        while(k<numRows){

            List<Integer> temp = new ArrayList<>();

            int tempSize = k+1; int i = 0;

            while(i<tempSize){
                temp.add(1);
                i++;
            }

            r.add(temp);

            if(k==0 || k==1) {
                k++;
                continue;
            }

            int j=1;

            while(j<tempSize-1){
                temp.set(j,r.get(k-1).get(j-1)+r.get(k-1).get(j));
                j++;
            }
            k++;
        }
        return r;
    }

    public static void main(String[] args) {
        PrintPascalsTriange p = new PrintPascalsTriange();
        List<List<Integer>> r = p.generate(5);

        System.out.println(r);
    }
}
