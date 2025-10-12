package com.example.practice.code.graphs.mst;

import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * To find MST for a given graph
 * Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
 * (Sometimes it may be asked to find the MST as well, where in the MST the edge-informations will be stored in the form {u, v}(u = starting node, v = ending node).)
 */
public class PrimsAlgorithm {

    private List<List<Pair>> createAdjList (int[][] edges, int v){
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        return adjList;
    }

    public int solutionSumWeights(int[][] edges, int v){

        int[] vis = new int[v];

        List<List<Pair>> adjList = createAdjList(edges,v);

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance);
        pq.add(new Pair(0,0));
        int sum = 0;

        while (!pq.isEmpty()){
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.remove();

            if(vis[node]==1) continue;

            vis[node] = 1;
            sum+=distance;

            for(Pair p:adjList.get(node)){
                int nextNode = p.node;

                if(vis[nextNode]==0){
                    pq.add(p);
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};

        PrimsAlgorithm obj = new PrimsAlgorithm();

        System.out.println(obj.solutionSumWeights(edges,V));

    }


}

class Pair{
    int node;
    int distance;

    public Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
