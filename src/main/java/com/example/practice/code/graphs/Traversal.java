package com.example.practice.code.graphs;

import java.util.*;

public class Traversal {

    //BFS
    /**
     * Graph is stored as an adjacency list/Matrix
     * Inital config needed - define a queue and add starting node to it. Also define a visited array to keep track of visited nodes.
     * After every popped node from queue, we check neighbors, put in queue and marked visited as 1
     * SC --> Number of nodes fpr storing in queue & result & visitor array O(3N) ~ O(N)
     * TC --> outer loop runs for n nodes and inner for loop runs for its degrees. The total number of degrees = 2* num_edges.
     * Therefor TC: O(n)+O(2*num_edges)
     */
    public ArrayList<Integer> bfsTraversal(int v, List<List<Integer>> adj){
        ArrayList<Integer> result = new ArrayList<>();
        int[] visited = new int[v];

        Queue<Integer> q= new LinkedList<>();
        q.offer(0);
        visited[0] = 1;

        while (!q.isEmpty()){
            int node = q.poll();
            result.add(node);

            for(int i: adj.get(node)){
                if(visited[i]==0){
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }

        return result;
    }

    /**
     * Start from one node and go towards depth
     * DFS will vary depending on starting node
     * Algo used - Recursion
     */
    public List<Integer> dfsTraversal(int v, List<List<Integer>> adj){
        List<Integer> dfsResult = new ArrayList<>();
        int[] visited = new int[v];
        visited[0] = 1;
        dfsTraversalHelper(0, adj,dfsResult, visited);
        return dfsResult;
    }

    public void dfsTraversalHelper(int node, List<List<Integer>> adj, List<Integer> dfsResult, int[] visited ){
        visited[node]= 1;
        dfsResult.add(node);

        for(int i: adj.get(node)){
            if(visited[i]!=1){
                dfsTraversalHelper(i,adj,dfsResult,visited);
            }
        }
    }

    public void printGraph(List<Integer> l){
        l.forEach(System.out::println);
    }


    public static void main(String[] args) {
        List<List<Integer>> adjacencyList = new ArrayList<>() {};
        adjacencyList.add(List.of(1,2,3));
        adjacencyList.add(List.of(0,4));
        adjacencyList.add(List.of(0,4,5));
        adjacencyList.add(List.of(0));
        adjacencyList.add(List.of(1,2,6));
        adjacencyList.add(List.of(2,7,8));
        adjacencyList.add(List.of(4,7));
        adjacencyList.add(List.of(6,5));
        adjacencyList.add(List.of(5));

        Traversal obj = new Traversal();
        List<Integer> bfs = obj.bfsTraversal(9, adjacencyList);
        System.out.println("BFS");
        obj.printGraph(bfs);


        List<Integer> dfs = obj.dfsTraversal(9, adjacencyList);
        System.out.println("DFS");
        obj.printGraph(dfs);
    }

}
