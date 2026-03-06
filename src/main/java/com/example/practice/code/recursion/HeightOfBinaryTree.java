package com.example.practice.code.recursion;

import com.example.practice.code.TreeDs;

public class HeightOfBinaryTree {


    public static int height(TreeDs tree){
        if(tree == null){
            return 0;
        }

        int lh = height(tree.left);
        int rh = height(tree.right);

        return 1+ Math.max(lh,rh);
    }

    public static void main(String[] args) {
        TreeDs tree = new TreeDs(1);
        tree.left = new TreeDs(2);
        tree.right = new TreeDs(3);
        tree.left.left = new TreeDs(4);
        tree.left.right = new TreeDs(5);
        tree.left.left.right = new TreeDs(6);

        System.out.println(height(tree));
    }

}
