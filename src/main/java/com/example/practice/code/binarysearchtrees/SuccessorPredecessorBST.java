package com.example.practice.code.binarysearchtrees;

/**
 * Given the root node of a binary search tree (BST) and an integer key. Return the Inorder predecessor and successor of the given key from the provided BST.
 * If predecessor or successor is missing then return -1.
 */
public class SuccessorPredecessorBST {

    /**
     * Multiple approaches
     * Method 1: Store the inorder traversal in list and binary search for key values and the next element will be successor TC: O(N)+O(logN) & SC: O(N)
     * Method 3: Store a variable successor and use BST property
     * @param root
     * @param key
     * @return
     */
    public TreeNode solutionSuccessor(TreeNode root, TreeNode key) {
        TreeNode successor = null;
        while (root!=null){
            if(key.data>=root.data){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }

        return successor;

    }

    public TreeNode solutionPredecessor(TreeNode root, TreeNode key) {
        TreeNode predecessor = null;
        while (root!=null){
            if(key.data>root.data){
                predecessor = root;
                root = root.right;
            }else{
                root = root.left;
            }
        }

        return predecessor;

    }


    public static void main(String[] args) {
        /**
         *         4
         *       2   7
         *      1 3 6
         *
         */
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));

        /**
         *         4
         *       2   7
         *      1 3 5
         *           6
         *
         */
        TreeNode root1 = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(5,null,new TreeNode(6)),null));

        SuccessorPredecessorBST obj = new SuccessorPredecessorBST();
        System.out.println(obj.solutionSuccessor(root,new TreeNode(6)).data);
        System.out.println(obj.solutionPredecessor(root,new TreeNode(6)).data);
        System.out.println(obj.solutionSuccessor(root1,new TreeNode(6)).data);
        System.out.println(obj.solutionPredecessor(root1,new TreeNode(6)).data);
    }

}
