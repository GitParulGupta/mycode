package com.example.practice.code.graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {

    public boolean isCyclic(int[][] edges, int vertices){

        List<List<Integer>> adjList = getAdjList(edges, vertices);

        int[] vis = new int[vertices+1];
        int[] pathVis = new int[vertices+1];

        for(int i = 1; i <=vertices; i++){

            if(vis[i]==0){
                if(dfs(i,adjList, vis,pathVis)){
                    return true;
                }
            }

        }
        return false;
    }

    private boolean dfs(int i, List<List<Integer>> adjList, int[] vis, int[] pathVis) {
        vis[i] = 1;
        pathVis[i] = 1;

        for(int node:adjList.get(i)){
            if(vis[node]==0){
                if(dfs(node,adjList, vis,pathVis)){
                    return true;
                }else if(pathVis[node]==1){
                    return true;
                }
            }
        }
        pathVis[i] = 0;
        return false;
    }


    private List<List<Integer>> getAdjList(int[][] edges, int vertices){

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<=vertices;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        return adjList;
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph obj = new DetectCycleInDirectedGraph();
        int[][] edges = {{1,2},{2,3},{3,4},{4,6},{6,7},{3,5},{5,6},{2,8},{8,9},{9,10},{10,8}};
        System.out.println(obj.isCyclic(edges, 10));
    }

}
