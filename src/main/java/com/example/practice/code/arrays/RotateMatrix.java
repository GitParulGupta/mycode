package com.example.practice.code.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a 2-D array rotate matrix by 90
 *
 */
public class RotateMatrix {
    private static final String FORWARD_DIRECTION = "Forward";
    private static final String BACKWARD_DIRECTION = "Backward";
    private static final String DOWNWARD_DIRECTION = "Downward";
    private static final String UPWARD_DIRECTION = "Upward";

    private void printArray(int[][] a, String message){
        System.out.println(message);
        for (int[] row : a) {
            System.out.println(Arrays.toString(row));
        }
    }

    private void swapElements(int[][] a, int i, int j){
        int temp = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = temp;
    }

    private void reverseArrayElements(int[] a){
        int i=0; int j=a.length-1;
        while(i<j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    public void rotateBy90_Optimal(int[][] a){
        printArray(a, "Array before rotating by 90 right");
        //Transpose
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                swapElements(a,i,j);
            }
        }
        //reverse rows
        for (int[] row : a) {
            reverseArrayElements(row);
        }
        printArray(a, "Array after rotating by 90 right");
    }

    public void spiralTraversal(int[][] a){
        int rowStart = 0;
        int rowEnd = a.length-1;
        int colStart = 0;
        int colEnd = a[0].length-1;

        List<Integer> l = new ArrayList<>();

        while(rowStart<=rowEnd && colStart<=colEnd){
            l.addAll(rowTraversal(colStart, colEnd,rowStart,a,FORWARD_DIRECTION));
            rowStart++;
            l.addAll(columnTraversal(rowStart,rowEnd,colEnd,a,DOWNWARD_DIRECTION));
            colEnd--;
            if(rowStart<=rowEnd){
                l.addAll(rowTraversal(colEnd,colStart,rowEnd,a,BACKWARD_DIRECTION));
                rowEnd--;
            }
            if(colStart<=colEnd){
                l.addAll(columnTraversal(rowEnd,rowStart,colStart,a,UPWARD_DIRECTION));
                colStart++;
            }
        }

        System.out.println(l);

    }

    private List<Integer> rowTraversal(int start, int end, int row, int[][]a, String direction){
        List<Integer> rowList = new ArrayList<>();
        if(direction.equals(FORWARD_DIRECTION)){
            while(start<=end){
                rowList.add(a[row][start]);
                start++;
            }
        }else if(direction.equals(BACKWARD_DIRECTION)){
            while(start>=end){
                rowList.add(a[row][start]);
                start--;
            }
        }
        return rowList;
    }


    private List<Integer> columnTraversal(int start, int end, int column, int[][]a, String direction){
        List<Integer> colList = new ArrayList<>();
        if(direction.equals(DOWNWARD_DIRECTION)){
            while(start<=end){
                colList.add(a[start][column]);
                start++;
            }
        }else if(direction.equals(UPWARD_DIRECTION)){
            while(start>=end){
                colList.add(a[start][column]);
                start--;
            }
        }
        return colList;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        RotateMatrix obj = new RotateMatrix();
        obj.rotateBy90_Optimal(a);
        obj.spiralTraversal(a);
        int[][] b = {{1,2,3},{5,6,7},{9,10,11},{13,14,15}};
        obj.spiralTraversal(b);
        int[][] c = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        obj.spiralTraversal(c);
    }

}
