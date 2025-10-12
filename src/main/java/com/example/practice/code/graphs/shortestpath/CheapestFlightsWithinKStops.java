package com.example.practice.code.graphs.shortestpath;

import java.util.*;

/**
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi,
 * pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Input: n = 5, flights = [[1,2,10],[2,0,7],[1,3,8],[4,0,10],[3,4,2],[4,2,10],[0,3,3],[3,1,6],[2,4,5]], src = 0,dst = 4, k = 1
 * Input: n = 2, flights = [[1,0,5]], src = 0, dst = 1, k = 1
 */
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<NodeDistance>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adjList.get(flights[i][0]).add(new NodeDistance(flights[i][1],flights[i][2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist,(int)(1e9));

        Queue<StopsTuple> q = new LinkedList<>();
        q.add(new StopsTuple(0,src,0));
        dist[src]=0;

        while (!q.isEmpty()){
            StopsTuple current = q.poll();
            int curStop = current.stops;
            int curNode = current.node;
            int curCost = current.cost;

            if(curStop>k) continue;

            for(NodeDistance node : adjList.get(curNode)){
                int cost = node.distance;
                int nextNode = node.node;
                if(curCost+cost<dist[nextNode] && curStop<=k){
                    q.add(new StopsTuple(curStop+1,nextNode,curCost+cost));
                    dist[nextNode]=curCost+cost;
                }
            }
        }

        if(dist[dst]==(int)(1e9)) return -1;

        return dist[dst];
    }



}

class StopsTuple{
    int stops;
    int node;
    int cost;

    public StopsTuple(int stops, int node, int cost){
        this.stops= stops;
        this.node = node;
        this.cost = cost;
    }
}
