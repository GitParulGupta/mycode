package com.example.practice.code.graphs.shortestpath;

import java.util.*;

/**
 * Given an Undirected Graph having unit weight, find the shortest path from the source to all other nodes in this graph. In this problem statement, we have assumed the source vertex to be ‘0’. If a vertex is unreachable from the source node, then return -1 for that vertex.
 * Input:
 * n = 9, m = 10
 * edges = [[0,1],[0,3],[3,4],[4 ,5],[5, 6],[1,2],[2,6],[6,7],[7,8],[6,8]]
 * src=0
 * Output: 0 1 2 1 2 3 3 4 4
 */
public class UnweightedGraphShortestDistance {

    public int[] shortestPath(int[][] edges, int N, int M) {
        //create adjacency list
        List<List<Integer>> adjList = createAdjacencyList(edges,N);

        int[] distance = new int[N];
        for(int i=0;i<distance.length;i++){
            distance[i] = -1;
        }

        int[] visited = new int[N];

        //BFS
        Queue<NodeDistancePair> queue = new LinkedList<>();
        queue.add(new NodeDistancePair(0,0));
        visited[0] = 1;

        while (!queue.isEmpty()){
            NodeDistancePair current = queue.poll();
            int curNode = current.node;
            int curDistance = current.distance;

            if(distance[curNode]==-1){
                distance[curNode] = curDistance;
            }

            for(int i:adjList.get(curNode)){
                if(visited[i]==0){
                    queue.add(new NodeDistancePair(i,curDistance+1));
                    visited[i] = 1;
                }
            }
        }

        return distance;
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
        int[][] edges = {{0,1},{0,3},{3,4},{4 ,5},{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        UnweightedGraphShortestDistance obj = new UnweightedGraphShortestDistance();
        int[] distanceResult = obj.shortestPath(edges,9,10);

        Arrays.stream(distanceResult).forEach(System.out::println);
    }

}

class NodeDistancePair{
    int node;
    int distance;

    public NodeDistancePair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
