package com.example.practice.code.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */
public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> q= new LinkedList<>();

        int cntFresh=0;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }else {
                    visited[i][j]=0;
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }
         int[] dRow = {0,1,0,-1};
         int[] dCol = {1,0,-1,0};
         int tm = 0;
         int count = 0;
        while (!q.isEmpty()){
            Pair p = q.poll();
            int curRow = p.row;
            int curCol = p.col;
            int curTime = p.time;
            tm = Math.max(curTime,tm);//why ??

            for(int i=0;i<4;i++){
                int nextRow = curRow+dRow[i];
                int nextCol = curCol+dCol[i];

                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && visited[nextRow][nextCol]==0 && grid[nextRow][nextCol]==1){
                    q.add(new Pair(nextRow,nextCol,curTime+1));
                    visited[nextRow][nextCol] = 2;
                    count++;
                }
            }
        }

        if(count!=cntFresh) return -1;
        return tm;

    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {1,1,0},{0,1,1}};

        RottenOranges obj = new RottenOranges();
        System.out.println(obj.orangesRotting(grid));
    }

}

class Pair{
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}