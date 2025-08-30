package com.example.practice.code.binarysearchtrees;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */
public class InsertNode {

    public TreeNode solution(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (cur!=null){

            if(cur.data<=val){
                if(cur.right!=null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }

            }else{
                if(cur.left!=null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
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

        /**
         *          4
         *      2      7
         *   1    3  6
         */

        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));

        InsertNode obj = new InsertNode();
        TreeNode ans = obj.solution(root,5);

        obj.inorderTraversal(ans);
    }

}
