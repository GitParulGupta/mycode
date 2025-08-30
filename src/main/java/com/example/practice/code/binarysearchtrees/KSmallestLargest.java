package com.example.practice.code.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 */
public class KSmallestLargest {

    public int solutionSmallest(TreeNode root, int k){
        List<Integer> list = new ArrayList<>();
        inorderHelper(root,list);
        return list.get(k-1);
    }

    //Morris Traversal

    /*public int solutionSmallestOptimised(TreeNode treeNode, int k){
        return solutionSmallestOptimisedHelper(treeNode,0,k);
    }
*/
    /*private int solutionSmallestOptimisedHelper(TreeNode node, int count, int k){
        if(node==null){
            return count;
        }

        if(count==k){
            return node.data;
        }

        return  1 + solutionSmallestOptimisedHelper(node.left,count,k)+ solutionSmallestOptimisedHelper(node.right,count,k);
    }*/

    private int inorder(TreeNode node){
        List<Integer> nodes = new ArrayList<>();
        return inorderHelper(node,nodes).size();
    }

    private List<Integer> inorderHelper(TreeNode node, List<Integer> nodes) {
        if(node==null){
            return nodes;
        }
        inorderHelper(node.left, nodes);
        nodes.add(node.data);
        inorderHelper(node.right,nodes);
        return nodes;
    }

    private int countNodes(TreeNode node){
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        /**
         *          4
         *      2      7
         *   1    3  6
         */

        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));
        KSmallestLargest obj = new KSmallestLargest();
        int numNodes = obj.countNodes(root);
        System.out.println("Number of nodes: "+numNodes);

        System.out.println("KSmallest: "+obj.solutionSmallest(root,3));
        //System.out.println("KSmallestOptimised: "+obj.solutionSmallestOptimised(root,3));
    }
}
