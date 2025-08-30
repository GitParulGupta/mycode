package com.example.practice.code.binarysearchtrees;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */
public class DeleteNode {

    public TreeNode solution(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        
        if(root.data==val){
            return helper(root);
        }

        TreeNode temp = root;

        while (root!=null){
            if(root.data<val){
                if(root.right!=null && root.right.data==val){
                    root.right = helper(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }else{
                if(root.left!=null && root.left.data==val){
                    root.left = helper(root.left);
                    break;
                }else {
                    root = root.left;
                }
            }
        }

        return temp;
        
    }

    private TreeNode helper(TreeNode root) {

        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }else{
            TreeNode lastRight = root.right;
            TreeNode lastRightForReplacement = findLastRight(root.left);
            lastRightForReplacement.right = lastRight;
            return root.left;
        }
    }

    private TreeNode findLastRight(TreeNode node){
        if(node.right==null){
            return node;
        }
        return findLastRight(node.right);
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

        DeleteNode obj = new DeleteNode();
        TreeNode ans = obj.solution(root,2);
        /**
         * Afetr deletion
         *          4
         *      1     7
         *       3  6
         */
        obj.inorderTraversal(ans);
    }

}
