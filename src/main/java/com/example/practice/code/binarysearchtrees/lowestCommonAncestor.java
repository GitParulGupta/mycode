package com.example.practice.code.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root node of a binary search tree (BST) and two node values p,q.
 * Return the lowest common ancestors(LCA) of the two nodes in BST.
 * Input : root = [5, 3, 6, 2, 4, null, 7] , p = 2, q = 4
 * Output : [3]
 */
public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q){
        if(root==null) return null;
        int cur = root.data;
        if(cur<p &&cur<q){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(cur>p && cur > q){
            return lowestCommonAncestor(root.left,p,q);
        }

        return root;
    }

    public static void main(String[] args) {
        /**
         *          4
         *      2      7
         *   1    3  6
         */

        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));
        lowestCommonAncestor obj = new lowestCommonAncestor();

        System.out.println("LCA: "+obj.lowestCommonAncestor(root,1,3).data);


        System.out.println("LCA: "+obj.lowestCommonAncestor(root,7,6).data);
    }
}
