package com.example.practice.code.graphs.shortestpath;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary matrix of size N x M. The task is to find the shortest path from the source cell (0, 0) to the destination
 * cell (N-1, M-1). The path can only be created out of a cell if its value is 1. If the path is not possible, return -1.
 * Note: You can move to any of the 8 cells surrounding a cell.
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 */
public class ShortestDistanceBinaryMaze {

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0]==1){
            return -1;
        }

        int[][] distance = new int[grid.length][grid[0].length];

        for(int[] ar:distance){
            Arrays.fill(ar,(int)(1e9));
        }

        int destinationRow = grid.length-1;
        int destinationCol = grid[0].length-1;

        Queue<DistanceCoords> queue = new LinkedList<>();
        queue.add(new DistanceCoords(1,0,0));
        distance[0][0] =1;

        int[] dRow = {-1,-1,0,1,1,0,-1,-1};
        int[] dCol = {0,1,1,1,0,-1,-1,0};

        while (!queue.isEmpty()){

            DistanceCoords distanceCoords = queue.poll();
            int curDistance = distanceCoords.distance;
            int curRow = distanceCoords.row;
            int curCol = distanceCoords.col;

            for(int i=0;i<8;i++){
                int nextRow = curRow+dRow[i];
                int nextCol = curCol+dCol[i];
                if(nextRow>=0 && nextRow<= destinationRow && nextCol>=0 && nextCol<=destinationCol && grid[nextRow][nextCol] !=1 && distance[nextRow][nextCol]==(int)(1e9)){
                    distance[nextRow][nextCol] = curDistance+1;
                    if(nextRow==destinationRow && nextCol==destinationCol){
                        return distance[nextRow][nextCol];
                    }
                    queue.add(new DistanceCoords(distance[nextRow][nextCol],nextRow,nextCol));

                }


            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestDistanceBinaryMaze obj= new ShortestDistanceBinaryMaze();

        int[][] input1 = {{0,1},{1,0}};
        System.out.println("Input 1: "+obj.shortestPathBinaryMatrix(input1));

        int[][] input2 = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println("Input 2: "+obj.shortestPathBinaryMatrix(input2));

        int[][] input3 = {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println("Input 3: "+obj.shortestPathBinaryMatrix(input3));
    }

}

class DistanceCoords{
    int distance;
    int row;
    int col;

    public DistanceCoords(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
