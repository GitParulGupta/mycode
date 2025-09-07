package com.example.practice.code.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 1 for each cell.
 * The distance between two cells sharing a common edge is 1.
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 */
public class DistanceOfNearestCell {

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<PairDistance> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    q.add(new PairDistance(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] dRow = {0,1,0,-1};
        int[] dCol = {1,0,-1,0};

        while (!q.isEmpty()){
            PairDistance p = q.poll();
            int row = p.row;
            int col = p.col;
            int curDistance = p.distance;

            distance[row][col] = curDistance;

            for(int i=0;i<4;i++){
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];

                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && visited[nextRow][nextCol]==0){
                    q.add(new PairDistance(nextRow,nextCol,curDistance+1));
                    visited[nextRow][nextCol]=1;
                }
            }
        }

        return distance;

    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        DistanceOfNearestCell obj = new DistanceOfNearestCell();
        int[][] result = obj.updateMatrix(mat);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.print("\n");

        }
    }

}

class PairDistance{
    int row;
    int col;
    int distance;
    public PairDistance(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
