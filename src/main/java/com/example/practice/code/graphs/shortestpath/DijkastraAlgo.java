package com.example.practice.code.graphs.shortestpath;

import java.util.*;

/**
 * Given a weighted, undirected graph of V vertices, numbered from 0 to V-1, and an adjacency list adj where adj[i]
 * represents all edges from vertex i.
 * Each entry in adj[i] is of the form [to, weight], where:
 * to → the neighboring vertex connected to i,
 * weight → the weight of the edge between i and to.
 * Given a source node S. Find the shortest distance of all the vertex from the source vertex S. Return a list of integers
 * denoting shortest distance between each node and source vertex S. If a vertex is not reachable from source then its distance
 * will be 109.
 * Input: V = 2, adj [] = [[[1, 9]], [[0, 9]]], S=0
 * Output: [0, 9]
 * Dijasktras does not work with negative weights as the algo will fall into infinite loop
 * Why queue is not prefered instead of PQ --> we explore the minimum distance first
 * TC: E log V --> e--> number of edges and V --> number of edges
 * https://www.youtube.com/watch?v=3dINsjyfooY&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=34 ==> for TC - review
 */
public class DijkastraAlgo {

    //num_vertices, list of list of list(node at 0 and weight at 1), int source
    public  int[] dijkstraUsingPQ(int V, List<List<List<Integer>>> adj, int S) {

        int[] distance = new int[V];

        Arrays.fill(distance, (int) (1e9));

        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

        distance[S] =0;
        pq.add(new NodeDistance(S,0));

        while (!pq.isEmpty()){
            int curDistance = pq.peek().distance;
            int curNode = pq.peek().node;
            pq.poll();

            for(int i=0;i<adj.get(curNode).size();i++){
                int nextDistance = adj.get(curNode).get(i).get(1);
                int nextNode = adj.get(curNode).get(i).get(0);

                if(curDistance+nextDistance<distance[nextNode]){
                    distance[nextNode] = curDistance+nextDistance;
                    pq.add(new NodeDistance(nextNode,distance[nextNode]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<List<Integer>>> adjList = new ArrayList<>();
        adjList.add(List.of(List.of(1,4),List.of(2,4)));
        adjList.add(List.of(List.of(0,4),List.of(2,2)));
        adjList.add(List.of(List.of(0,4),List.of(1,2), List.of(3,3), List.of(5,6), List.of(4,1)));
        adjList.add(List.of(List.of(2,3),List.of(5,2)));
        adjList.add(List.of(List.of(2,1),List.of(5,3)));
        adjList.add(List.of(List.of(4,3),List.of(2,6), List.of(3,2)));
        int s = 0;


        DijkastraAlgo obj = new DijkastraAlgo();
        int[] result = obj.dijkstraUsingPQ(V,adjList,s);

        Arrays.stream(result).forEach(System.out::println);
    }

}
