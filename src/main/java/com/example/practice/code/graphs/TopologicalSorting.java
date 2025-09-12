package com.example.practice.code.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * opological sorting only exists in Directed Acyclic Graph (DAG).
 * If the nodes of a graph are connected through directed edges and the graph does not contain a cycle,
 * it is called a directed acyclic graph(DAG).
 *
 * The topological sorting of a directed acyclic graph is nothing but the linear ordering of vertices such that
 * if there is an edge between node u and v(u -> v), node u appears before v in that ordering.
 *
 *  5--> 0 <--4
 * |          |    points downward
 * 2--->3---> 1
 *
 * Top sort : 5 4 2 3 1 0 -- one of the topological sort
 * Given a Directed Acyclic Graph (DAG) with V vertices labeled from 0 to V-1.
 * The graph is represented using an adjacency list where adj[i] lists all nodes connected to node.
 * Find any Topological Sorting of that Graph.
 * In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).
 */
public class TopologicalSorting {

    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];

        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(adj,i,stack,visited);
            }
        }

        int[] ans = new int[V];
        int i=0;
        while (!stack.empty()){
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }

    private void dfs(List<List<Integer>> adj, int i, Stack<Integer> stack, int[] visited) {

        visited[i]=1;

        for(int node:adj.get(i)){
            if(visited[node]==0){
                dfs(adj,node,stack,visited);
            }
        }
        stack.push(i);
    }


    public List<List<Integer>> createAdjacencyList(int[][] edges, int N){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<N;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        return adjList;
    }

    public static void main(String[] args) {
        int[][] edges = {{5,0},{4,0},{5,2},{2,3},{3,1},{4,1}};

        TopologicalSorting obj = new TopologicalSorting();
        List<List<Integer>> adjList = obj.createAdjacencyList(edges,6);
        int[] res = obj.topoSort(6,adjList);
        Arrays.stream(res).forEach(System.out::println);
    }

}
