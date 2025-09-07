package com.example.practice.code.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a class, st it can be coloured with exactly 2 colours such that no 2 nodes are adjacent.
 * https://leetcode.com/problems/is-graph-bipartite/description/
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 *  There are no self-edges (graph[u] does not contain u).
 *  There are no parallel edges (graph[u] does not contain duplicate values).
 *  If v is in graph[u], then u is in graph[v] (the graph is undirected).
 *  The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 *  A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 *  Return true if and only if it is bipartite.
 *  If a graph h odd length cycle, it cannot be bipartite graph
 *  Any liner length graph is always bipartite
 *  DFS & Adjacency List
 *
 */
public class BipartiteGraph {

    private List<List<Integer>> createAdjacencyList(int[][] graph){

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            List<Integer> connections = new ArrayList<>();
            for(int j = 0;j<graph[i].length;j++){
                connections.add(graph[i][j]);
            }
            adjacencyList.add(connections);
        }
        return adjacencyList;
    }

    public boolean isBipartite(int[][] graph) {

        List<List<Integer>> adjList = createAdjacencyList(graph);

        int[] color = new int[graph.length];

        Arrays.fill(color, -1);

        for(int i=0;i<color.length;i++){
            if(color[i]==-1){
                if(dfs(adjList, color,i,0)==false) return false;
            }
        }

        return true;

    }

    private boolean dfs(List<List<Integer>> adjList, int[] color, int node, int curColor) {
        color[node] = curColor;

        for(int nextNode: adjList.get(node)){
            if(color[nextNode]==-1){
                if(dfs(adjList,color,nextNode,1-curColor) ==false) return false;
            }else if(color[nextNode]==curColor){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};

        BipartiteGraph obj= new BipartiteGraph();
        System.out.println(obj.isBipartite(graph));


        int[][] graph2 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(obj.isBipartite(graph2));
    }
}
