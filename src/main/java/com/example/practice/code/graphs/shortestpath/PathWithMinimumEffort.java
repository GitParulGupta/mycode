package com.example.practice.code.graphs.shortestpath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col]
 * represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 */
public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        int[][] distance = new int[rows][columns];

        for(int[] ar:distance){
            Arrays.fill(ar,(int)(1e9));
        }

        PriorityQueue<HeightDifference> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.difference));
        pq.add(new HeightDifference(0,0,0));
        distance[0][0] = 0;

        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};

        while(!pq.isEmpty()){
            HeightDifference heightDifference = pq.poll();
            int curDifference = heightDifference.difference;
            int curRow = heightDifference.row;
            int curCol = heightDifference.column;

            if(curRow==rows-1 && curCol==columns-1) return curDifference;

            for(int i=0;i<4;i++){
                int nextRow = curRow+dRow[i];
                int nextCol = curCol+dCol[i];

                if(nextRow>=0 && nextRow<rows && nextCol>=0 && nextCol<columns){
                    int nextDifference = Math.abs(heights[nextRow][nextCol]-heights[curRow][curCol]);
                    int nextEffort = Math.max(nextDifference,curDifference);
                    if(nextEffort<distance[nextRow][nextCol]){
                        distance[nextRow][nextCol]=nextEffort;
                        pq.add(new HeightDifference(nextEffort,nextRow,nextCol));
                    }
                }
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        PathWithMinimumEffort obj = new PathWithMinimumEffort();

        //[[1,2,2],[3,8,2],[5,3,5]]
        int[][] input1 = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println("Input 1: "+obj.minimumEffortPath(input1)); 

        //[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
        int[][] input2 = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        System.out.println("Input 2: "+obj.minimumEffortPath(input2));

    }

}

class HeightDifference{
    int difference;
    int row;
    int column;

    public HeightDifference(int difference, int row, int column){
        this.difference = difference;
        this.row = row;
        this.column = column;
    }
}
