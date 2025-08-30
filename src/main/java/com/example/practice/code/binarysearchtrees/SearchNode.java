package com.example.practice.code.binarysearchtrees;

import com.example.practice.code.binarysearchtrees.TreeNode;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */
public class SearchNode {

    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null && root.data!=val){
            root = root.data<val?root.right:root.left;
        }
        return root;
    }

    public void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));

        SearchNode obj = new SearchNode();
        TreeNode ans = obj.searchBST(root,2);

        obj.inorderTraversal(ans);
    }

}
