package com.example.practice.code.binarytrees;

/**
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class CheckBalanced {

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        int lsh = maxDepth(root.left);
        int rsh = maxDepth(root.right);

        if (Math.abs(lsh-rsh) > 1 ) return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if(!left || !right) return false;

        return true;
    }

    private int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1+Math.max(lh,rh);
    }
}
