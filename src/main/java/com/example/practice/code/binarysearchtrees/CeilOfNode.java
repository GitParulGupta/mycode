package com.example.practice.code.binarysearchtrees;

/**
 * Given a Binary Search Tree and a key, return the ceiling of the given key in the Binary Search Tree.
 * Ceiling of a value refers to the value of the smallest node in the Binary Search Tree that is greater than or equal to the given key.
 * If the ceiling node does not exist, return nullptr.
 */
public class CeilOfNode {

    public int solution(TreeNode root, int val) {
        int ceil = -1;
        while(root!=null){
            if(root.data==val){
                ceil = root.data;
                return ceil;
            }else if(root.data<val){
                root = root.right;
            }else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));

        CeilOfNode obj = new CeilOfNode();
        System.out.println(obj.solution(root,5));
    }

}
