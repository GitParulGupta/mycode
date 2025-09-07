package com.example.practice.code.binarysearchtrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 */
public class ValidateBST {

    public boolean validateBST(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorderHelper(root,list);

        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){ //= for duplicates
                return false;
            }
        }
        return true;
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

    public boolean solutionOptimal(TreeNode root){
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return isValidBST(root, min, max);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if(root==null) return true;

        if(root.data<=min || root.data>=max) return false;

        return isValidBST(root.left,min, root.data) && isValidBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        /**
         *          4
         *      2      7
         *   1    3  6
         */

        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));

        /**
         *          4
         *      2      7
         *   8    3  6    9
         */

        TreeNode root1 = new TreeNode(4,new TreeNode(2,new TreeNode(8),new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(1)));

        ValidateBST obj = new ValidateBST();

        System.out.println("IS BST: "+obj.validateBST(root));
        System.out.println("IS BST optimal: "+obj.solutionOptimal(root));
        System.out.println("IS BST 2: "+obj.validateBST(root1));
        System.out.println("IS BST 2 optimal: "+obj.solutionOptimal(root1));
    }
}
