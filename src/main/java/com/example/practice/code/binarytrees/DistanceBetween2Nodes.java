package com.example.practice.code.binarytrees;

/**
 * Given a binary tree and the value of two nodes, find the distance between the given two nodes of the Binary Tree.
 * Distance between two nodes is defined as the minimum number of edges in the path from one node to another.
 * Constraints:
 * 1 <= T <= 10 ^ 2
 * 1 <= N <= 3 * 10 ^ 3
 * 0 <= DATA <= 10 ^ 6 and DATA != -1
 * Where ‘T’ is the number of test cases, ‘N’ is the total number of nodes in the binary tree, and ‘DATA’ is the value of the binary tree node.
 */
public class DistanceBetween2Nodes {

    public int distanceBetweenNodes(TreeNode root, int node1, int node2){

        TreeNode lca = lcaOfNodes(root, node1, node2);

        if(lca==null){
            return -1;
        }

        int d1 = distanceBetweenParentToNode(lca, node1,0);
        int d2 = distanceBetweenParentToNode(lca, node2,0);

        return d1+d2;
    }

    private int distanceBetweenParentToNode(TreeNode root, int node1, int distance) {

        if(root==null){
            return -1;
        }

        if(root.data==node1){
            return distance;
        }

        int left = distanceBetweenParentToNode(root.left,node1,distance+1);
        if(left!=-1){
            return left;
        }

        int right = distanceBetweenParentToNode(root.right,node1, distance+1);
        return right;
    }

    private TreeNode lcaOfNodes(TreeNode root, int node1, int node2) {

        if(root==null || root.data==node1 || root.data==node2){
            return root;
        }

        TreeNode left = lcaOfNodes(root.left,node1, node2);
        TreeNode right = lcaOfNodes(root.right, node1, node2);

        if(left==null){
            return right;
        } else if (right==null) {
            return left;
        }else{
            return root;
        }
    }


}
