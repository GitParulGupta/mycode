package com.example.practice.code.graphs.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a DAG, find the shortest path from the source to all other nodes in this DAG.
 * In this problem statement, we have assumed the source vertex to be ‘0’. You will be given the weighted edges of the graph.
 * Note: What is a DAG ( Directed Acyclic Graph)?
 * A Directed Graph (containing one-sided edges) having no cycles is said to be a Directed Acyclic Graph.
 * Input: n = 6, m= 7
 * edges =[[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
 * Output: 0 2 3 6 1 5
 */
public class ShortestPathDag {

    public List<List<NodeDistance>> createAdjacencyList(int[][] edges, int N){
        List<List<NodeDistance>> adjList = new ArrayList<>();
        for(int i=0;i<N;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(new NodeDistance(edges[i][1], edges[i][2]));
        }
        return adjList;
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<NodeDistance>> adjList = createAdjacencyList(edges,N);

        int[] visited = new int[N];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<N;i++){
            if(visited[i]==0){
                topoSort(adjList,i,visited,stack);
            }
        }

        int[] distance = new int[N];

        for(int i=0;i<N;i++){
            distance[i] = (int)(1e9);
        }

        distance[0]=0;//source is 0
        while (!stack.isEmpty()){
            int node = stack.pop();

            for(int i=0;i<adjList.get(node).size();i++){
                int v = adjList.get(node).get(i).node;
                int dist = adjList.get(node).get(i).distance;

                if(distance[node]+dist<distance[v]){
                    distance[v] = distance[node]+dist;
                }
            }
        }

        return distance;
    }

    private void topoSort(List<List<NodeDistance>> adjList, int i, int[] visited, Stack<Integer> stack) {

        visited[i]=1;
        for(NodeDistance node:adjList.get(i)){
            if(visited[node.node]==0){
                topoSort(adjList,node.node,visited,stack);
            }
        }
        stack.push(i);
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        ShortestPathDag obj = new ShortestPathDag();
        int[] distanceResult = obj.shortestPath(6,7,edges);

        Arrays.stream(distanceResult).forEach(System.out::println);
    }
}


class NodeDistance{
    int node;
    int distance;

    public NodeDistance(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}