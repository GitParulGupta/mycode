package com.example.practice.code.graphs.shortestpath;

import java.util.*;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed
 * edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source
 * to target.
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {

        int[] minTime = new int[n+1];
        Arrays.fill(minTime,(int)(1e9));

        List<List<NodeTimePair>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new NodeTimePair(times[i][1],times[i][2]));
        }

        PriorityQueue<NodeTimePair> pq = new PriorityQueue<>(Comparator.comparing((x->x.time)));
        pq.add(new NodeTimePair(k,0));
        minTime[k] = 0;

        while(!pq.isEmpty()){
            NodeTimePair ntp = pq.poll();
            int curNode = ntp.node;
            int curTime = ntp.time;

            for(NodeTimePair p:adj.get(curNode)){
                int nextNode = p.node;
                int nextTime = curTime + p.time;

                if(nextTime<minTime[nextNode]){
                    minTime[nextNode] = nextTime;
                    pq.add(new NodeTimePair(nextNode,nextTime));
                }
            }
        }

        int minimumTime = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(minTime[i]==(int)(1e9)){
                return -1;
            }else{
                minimumTime = Math.max(minimumTime,minTime[i]);
            }
        }

        return minimumTime;
    }

    public static void main(String[] args) {
        int[][] input1 = {{2,1,1},{2,3,1},{3,4,1}}; int n1 = 4; int k1 = 2;
        int[][] input2 = {{1,2,1}}; int n2 = 2; int k2 = 1;
        int[][] input3 = {{1,2,1}}; int n3 = 2; int k3 = 2;

        NetworkDelayTime obj = new NetworkDelayTime();

        System.out.println(obj.networkDelayTime(input1,n1,k1));
        System.out.println(obj.networkDelayTime(input2,n2,k2));
        System.out.println(obj.networkDelayTime(input3,n3,k3));

    }

}

class NodeTimePair{
    int node;
    int time;

    NodeTimePair(int node, int time){
        this.node = node;
        this.time = time;
    }
}
