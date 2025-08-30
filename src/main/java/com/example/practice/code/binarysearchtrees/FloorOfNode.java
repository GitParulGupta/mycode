package com.example.practice.code.binarysearchtrees;

/**
 * Given a root of binary search tree and a key(node) value, find the floor and ceil value for that particular key value.
 * Floor Value Node: Node with the greatest data lesser than or equal to the key value.
 * If a particular floor or ceil value is not present then output -1.
 */
public class FloorOfNode {

    public int solution(TreeNode root, int val) {
        int floor = root.data;
        while(root!=null){
            if(root.data==val){
                floor = root.data;
                return floor;
            }else if(root.data>val){
                root = root.left;
            }else{
                if(root.data<floor){
                    floor = root.data;
                }
                root = root.right;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),null));

        FloorOfNode obj = new FloorOfNode();
        System.out.println(obj.solution(root,5));
    }

}
