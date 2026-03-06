package com.example.practice.code.blackrock;

import java.util.ArrayList;
import java.util.List;

/**
 * You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting of only 0s and 1s. All the rows are sorted in ascending order.
 * Your task is to find the index of the row with the maximum number of ones.
 * Note: If two rows have the same number of ones, consider the one with a smaller index. If there's no row with at least 1 zero, return -1.
 * Example:
 *
 * Input: 'n' = 3, 'm' = 3, 'mat' = [[1, 1, 1], [0, 0, 1], [0, 0, 0]]
 *
 * Output: 0
 */
public class RowWithMax1 {

    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {

        int max1Row = -1; int num1= 0; boolean containsZero = false;

        for(int i=0;i<n;i++){

            int count1 = 0;

            for(int j=0;j<m;j++){
                if(!containsZero && mat.get(i).get(j).intValue()==0){
                    containsZero = true;
                }

                if(mat.get(i).get(j).intValue()==1){
                    count1++;
                }
            }

            if(num1<count1){
                num1 = count1;
                max1Row = i;
            }

        }

        if(!containsZero) return -1;

        return max1Row;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        ArrayList<Integer> row0 = new ArrayList<>();
        row0.add(1);
        row0.add(1);
        row0.add(1);
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(0);
        row1.add(0);
        row1.add(1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(0);
        row2.add(0);
        mat.add(row0);
        mat.add(row1);
        mat.add(row2);

        System.out.println(rowMaxOnes(mat, 3, 3));
    }
}
