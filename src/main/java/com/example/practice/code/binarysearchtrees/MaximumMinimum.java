package com.example.practice.code.binarysearchtrees;

/**
 * Find value of max node and min mode in BST
 */
public class MaximumMinimum {

    public int searchMinBST(TreeNode root) {
        int min = root.data;
        while(root!=null){
            min = Math.min(min, root.data);
            root = root.left;
        }
        return min;
    }

    public int searchMaxBST(TreeNode root) {
        int max = root.data;
        while(root!=null){
            max = Math.max(max, root.data);
            root = root.right;
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));

        MaximumMinimum obj = new MaximumMinimum();

        System.out.println("Minimum:"+obj.searchMinBST(root));

        System.out.println("Maximum:"+obj.searchMaxBST(root));

    }
}
