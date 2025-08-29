package com.example.practice.code.binarytrees;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTrees {

    public boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        return isSymmetric(root.left,root.right);

    }

    private boolean isSymmetric(TreeNode leftSubtree, TreeNode rightSubTree) {

        if(leftSubtree == null && rightSubTree == null){
            return true;
        }

        if(leftSubtree != null && rightSubTree == null){
            return false;
        }

        if(leftSubtree == null && rightSubTree != null){
            return false;
        }

        if(leftSubtree != null && rightSubTree != null && leftSubtree.data!=rightSubTree.data){
            return false;
        }

        boolean rl = isSymmetric(leftSubtree.right,rightSubTree.left);
        boolean lr = isSymmetric(leftSubtree.left,rightSubTree.right);
        return rl && lr;
    }

    /**
     *          1
     *      2       2
     *   3    4   4     3
     *      5  6 6  5
     * @param args
     */
    public static void main(String[] args) {

        TreeNode test = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(2,new TreeNode(4),new TreeNode(3)));
        test.left.right.left = new TreeNode(5);
        test.left.right.right = new TreeNode(6);
        test.right.left.left = new TreeNode(6);
        test.right.left.right = new TreeNode(5);

        SymmetricTrees st = new SymmetricTrees();
        System.out.println(st.isSymmetric(test));
    }
}
