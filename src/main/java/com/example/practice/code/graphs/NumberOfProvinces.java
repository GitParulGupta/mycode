package com.example.practice.code.graphs;


import java.util.ArrayList;
import java.util.List;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 *
 * 1-->2            4-->5       7
 *      \              /        \
 *       3             6         8
 */
public class NumberOfProvinces {

    private List<List<Integer>> createAdjacencyList(int[][] isConnected){

        List<List<Integer>> adjacencyList = new ArrayList<>();
        adjacencyList.add(new ArrayList<>());

        for(int i=0;i<isConnected.length;i++){
            List<Integer> connections = new ArrayList<>();
            for(int j = 0;j<isConnected.length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    connections.add(j+1);
                }
            }
            adjacencyList.add(connections);
        }
        return adjacencyList;
    }

    public int findCircleNum(int[][] isConnected) {
        int numVertices = isConnected.length;

        List<List<Integer>> adjacencyList = createAdjacencyList(isConnected);

        int[] visited = new int[numVertices+1];
        int count = 0;
        for(int i=1;i<=numVertices;i++){
            if(visited[i]==0){
                count++;
                dfs(i,adjacencyList,visited);
            }
        }

        return count;
    }

    public void dfs(int node, List<List<Integer>> adjacencyList, int[] visited){
        visited[node]=1;
        for(int i:adjacencyList.get(node)){
            if(visited[i]==0){
                dfs(i,adjacencyList,visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        NumberOfProvinces obj = new NumberOfProvinces();
        int ans = obj.findCircleNum(isConnected);

        System.out.println(ans);
    }

}
