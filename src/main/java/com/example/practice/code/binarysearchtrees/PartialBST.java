package com.example.practice.code.binarysearchtrees;

/**
 * Partial BST
 *  left nodes <= root
 *  right node >= root
 * Oracle
 */
public class PartialBST {

    public static boolean validateBST(TreeNode root){
        long min = Integer.MIN_VALUE;
        long max = Integer.MAX_VALUE;
        return validateBST(root,min,max);
    }

    private static boolean validateBST(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }
        if(root.data<min || root.data>max){
            return false;
        }
        return validateBST(root.left,min,root.data) && validateBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        /**
         *          4
         *      2      6
         *   1    3  6
         */

        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));

        /**
         *          4
         *      2      7
         *   8    3  1    9
         */

        TreeNode root1 = new TreeNode(4,new TreeNode(2,new TreeNode(8),new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(1)));

        PartialBST obj = new PartialBST();

        System.out.println("IS BST true: "+obj.validateBST(root));
        System.out.println("IS BST false: "+obj.validateBST(root1));
    }
}
