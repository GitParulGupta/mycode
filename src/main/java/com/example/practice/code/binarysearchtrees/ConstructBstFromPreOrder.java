package com.example.practice.code.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
 * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
 * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
 * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 *
 * Input: preorder = [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 */
public class ConstructBstFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE,new int[]{0});
    }

    private TreeNode bstFromPreorder(int[] preorder, int maxValue, int[] ints) {

        if(ints[0]==preorder.length||preorder[ints[0]]>maxValue) return null;
        TreeNode root = new TreeNode(preorder[ints[0]++]);//assignment and then incrememnt index
        root.left = bstFromPreorder(preorder,root.data,ints);
        root.right = bstFromPreorder(preorder, maxValue,ints);

        return root;
    }

    private List<Integer> inorder(TreeNode node, List<Integer> nodes) {
        if(node==null){
            return nodes;
        }
        if(nodes==null){
            nodes = new ArrayList<>();
        }
        inorder(node.left, nodes);
        nodes.add(node.data);
        inorder(node.right,nodes);
        return nodes;
    }

    public static void main(String[] args) {
        int[] preOrder = {8,5,1,7,10,12};
        ConstructBstFromPreOrder obj = new ConstructBstFromPreOrder();
        TreeNode root = obj.bstFromPreorder(preOrder);
        obj.inorder(root,null).stream().forEach(System.out::println);
    }
}
