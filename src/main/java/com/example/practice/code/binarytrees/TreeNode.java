package com.example.practice.code.binarytrees;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int key){
        this.data = key;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int key, TreeNode left, TreeNode right){
        this.data = key;
        this.left = left;
        this.right = right;
    }
}
