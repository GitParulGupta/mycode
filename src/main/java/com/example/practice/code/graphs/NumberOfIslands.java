package com.example.practice.code.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int islandCount = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    islandCount++;
                    vis[i][j] = true;
                    traverseIsland(grid,vis, new PairIsland(i,j));
                }
            }
        }
        return islandCount;
    }

    public void traverseIsland(char[][] grid,boolean[][] vis, PairIsland startingPoint){
        Queue<PairIsland> q = new LinkedList<>();
        q.add(startingPoint);

        int[] xDir = {0,1,0,-1};
        int[] yDir = {1,0,-1,0};

        int row = grid.length;
        int col = grid[0].length;

        while(!q.isEmpty()){
            PairIsland p = q.remove();
            int x = p.x;
            int y = p.y;

            for(int i=0;i<xDir.length;i++){
                int xNext = p.x+xDir[i];
                int yNext = p.y+yDir[i];
                if(xNext>=0 && xNext<row && yNext>=0 && yNext<col){
                    if(!vis[xNext][yNext] && grid[xNext][yNext]=='1'){
                        q.add(new PairIsland(xNext,yNext));
                        vis[xNext][yNext] = true;
                    }
                }
            }
        }
    }
}

class PairIsland {
    int x;
    int y;

    public PairIsland(int x, int y){
        this.x = x;
        this.y = y;
    }
}
