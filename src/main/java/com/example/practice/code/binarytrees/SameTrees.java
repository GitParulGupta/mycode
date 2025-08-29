package com.example.practice.code.binarytrees;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTrees {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if((p==null && q!=null) || (p!=null && q==null) ){
            return false;
        }

        int dataP = p.data;
        int dataQ = q.data;

        if(dataP!=dataQ){
            return false;
        }

        boolean checkP = isSameTree(p.left,q.left);
        boolean checkQ = isSameTree(p.right,q.right);

        return checkP && checkQ;
    }

}
