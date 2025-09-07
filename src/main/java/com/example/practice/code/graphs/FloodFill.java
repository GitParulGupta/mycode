package com.example.practice.code.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill:
 * Begin with the starting pixel and change its color to color.
 * Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
 * Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
 * The process stops when there are no more adjacent pixels of the original color to update.
 * Return the modified image after performing the flood fill.
 * Example 1:
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        boolean[][] visited = new boolean[n][m];

        int startingColor = image[sr][sc];
        image[sr][sc] = color;

        Queue<PairRowCol> q = new LinkedList<>();
        q.add(new PairRowCol(sr,sc));

        int[] dRow = {0,1,0,-1};
        int[] dCol = {1,0,-1,0};

        while (!q.isEmpty()){
            PairRowCol p = q.poll();
            int curRow = p.row;
            int curCol = p.col;

            for(int i=0;i<4;i++){
                int nextRow = curRow + dRow[i];
                int nextCol = curCol + dCol[i];
                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && image[nextRow][nextCol]==startingColor && !visited[nextRow][nextCol]){
                    q.add(new PairRowCol(nextRow,nextCol));
                    image[nextRow][nextCol] = color;
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return image;

    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1}, {1,1,0},{1,0,1}};

        FloodFill obj = new FloodFill();
        int[][] result = obj.floodFill(image, 1,1,2);

        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(result[i][j]);
            }
            System.out.print("\n");
        }

        int[][] image2 = {{0,0,0}, {0,0,0}};

        int[][] result2 = obj.floodFill(image2, 0,0,0);

        for(int i=0;i<image2.length;i++){
            for(int j=0;j<image2[0].length;j++){
                System.out.print(result2[i][j]);
            }
            System.out.print("\n");
        }
    }

}

class PairRowCol{
    int row;
    int col;
    public PairRowCol(int row, int col){
        this.row = row;
        this.col = col;
    }
}

