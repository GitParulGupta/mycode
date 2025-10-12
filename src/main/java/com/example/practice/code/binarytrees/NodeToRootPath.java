package com.example.practice.code.binarytrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement: Given a Binary Tree and a reference to a root belonging to it. Return the path from the root node to the given leaf node.
 * No two nodes in the tree have the same data value.
 * It is assured that the given node is present and a path always exists.
 */
public class NodeToRootPath {

    public List<Integer> solve(TreeNode root, int p) {
        List<Integer> l = new ArrayList<>();
        getPath(root,p,l);

        return l;
    }

    public boolean getPath(TreeNode root, int p, List<Integer> l) {

        if(root==null ){
            return false;
        }

        l.add(root.data);

        if(root.data==p){
            return true;
        }

        if(getPath(root.left,p,l)||getPath(root.right,p,l)){
            return true;
        }

        l.removeLast();
        return false;
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

        NodeToRootPath obj = new NodeToRootPath();
        List<Integer> ans = obj.solve(root,4);
        ans.stream().forEach(System.out::println);

    }
}
