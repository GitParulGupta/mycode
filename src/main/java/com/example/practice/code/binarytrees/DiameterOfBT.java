package com.example.practice.code.binarytrees;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBT {

    public int diameterOfBinaryTree(TreeNode root) {
        int max = 0;
        int diameter = diameterOfBinaryTreeHelper(root,max);
        return diameter;
    }

    private int diameterOfBinaryTreeHelper(TreeNode root, int maximum) {
        if(root==null) return maximum;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        maximum = Math.max(maximum, lh+rh);
        maximum = diameterOfBinaryTreeHelper(root.left,maximum);
        maximum = diameterOfBinaryTreeHelper(root.right,maximum);
        return maximum;
    }

    private int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1+Math.max(lh,rh);
    }

    public int diameterOfBinaryTreeOptimized(TreeNode root){
        int[] diameter = new int[1];
        return diameterOfBinaryTreeOptimizedHelper(root,diameter);
    }

    public int diameterOfBinaryTreeOptimizedHelper(TreeNode root, int[] diameter){
        if(root==null) return 0;
        int lh = diameterOfBinaryTreeOptimizedHelper(root.left,diameter);
        int rh = diameterOfBinaryTreeOptimizedHelper(root.right,diameter);
        diameter[0] = Math.max(diameter[0],lh+rh);
        return 1 + Math.max(lh,rh);
    }

}
