package com.example.practice.code.binarytrees;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * TC: O(n)
 * SC: O(n) --> auxiliary space
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || root.data==p.data || root.data ==q.data){
            return root;
        }

        TreeNode left =  lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }

    public static void main(String[] args) {

        /**
         *              3
         *        5             1
         *    6       2      0      8
         *          7   4
         *
         */
        //3,5,1,6,2,0,8,null,null,7,4
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2)), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode node = lca.lowestCommonAncestor(root, new TreeNode(7), new TreeNode(8));
        if (node != null) {
            System.out.println(node.data);
        }
    }
}
