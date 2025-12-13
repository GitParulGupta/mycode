package com.example.practice.code.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.naukri.com/code360/problems/dfs-traversal_630462?interviewProblemRedirection=true&company%5B%5D=Oracle,Oracle%20Software%20Services%20Software&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=PROBLEM
 *
 * Given an undirected and disconnected graph G(V, E), containing 'V' vertices and 'E' edges, the information about edges is given using 'GRAPH' matrix, where i-th edge is between GRAPH[i][0] and GRAPH[i][1]. print its DFS traversal.
 *
 * V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
 *
 * E is the number of edges present in graph G.
 * Note :
 * The Graph may not be connected i.e there may exist multiple components in a graph.
 *
 * Sample Input 1:
 * 5 4
 * 0 2
 * 0 1
 * 1 2
 * 3 4
 * Sample Output 1:
 * 2
 * 0 1 2
 * 3 4
 */
public class DFSTraversal {

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        List<List<Integer>> adjList = new ArrayList<>();
        adjList.addAll(getAdjList(v,edges));

        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){

            if(!visited[i]){
                ArrayList<Integer> l = new ArrayList<>();

                depthFirstSearchBaseHelper(i,adjList,l,visited);

                res.add(l);

            }

        }

        return res;
    }

    private static void depthFirstSearchBaseHelper(int v, List<List<Integer>> adjList, ArrayList<Integer> result, boolean[] visited){
        visited[v] =true;
        result.add(v);

        for(int i: adjList.get(v)){
            if(!visited[i]){
                depthFirstSearchBaseHelper(i,adjList,result,visited);
            }
        }
    }


    private static List<List<Integer>> getAdjList(int v, ArrayList<ArrayList<Integer>> edges){
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.size();i++){
            adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adjList.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        return adjList;
    }

}
