package com.example.practice.code.binarytrees;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a root of Binary Tree, perform the boundary traversal of the tree.
 * The boundary traversal is the process of visiting the boundary nodes of the binary tree in the anticlockwise direction, starting from the root.
 * The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from left-to-right, and the reverse order of the right boundary.
 * The left boundary is the set of nodes defined by the following:
 * The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary is empty
 * If a node in the left boundary and has a left child, then the left child is in the left boundary.
 * If a node is in the left boundary, has no left child, but has a right child, then the right child is in the left boundary.
 * The leftmost leaf is not in the left boundary.
 * The right boundary is similar to the left boundary, except it is the right side of the root's right subtree. Again, the leaf is not part of the right boundary, and the right boundary is empty if the root does not have a right child.*
 * Anti-clockwise traversal
 * left boundary excluding leaf
 * leaf nodes - inorder traversal
 * right boundary in the reverse
 *
 * TC: O(height of tree)+O(n)+O(height) ~ O(n)
 * SC: O(n) -->auxiliary stack space
 */
public class BoundaryTraversal {

    private boolean isLeaf(TreeNode node){
        return node!=null && node.left==null && node.right==null;
    }

    public List<Integer> printBoundary(TreeNode root){

        List<Integer> ans = new ArrayList<>();

        if(!isLeaf(root)){
            ans.add(root.data);
        }

        addLeftBoundary(root,ans);
        addLeaves(root,ans);
        addRightBoundary(root,ans);

        return ans;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> ans){
        TreeNode cur = node.left;
        while(cur!=null){
            if(!isLeaf(cur)) ans.add(cur.data);
            if(cur.left!=null) cur = cur.left;
            else cur=cur.right;
        }
    }

    private void addLeaves(TreeNode node, List<Integer> ans){
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }
        if(node.left!=null) addLeaves(node.left,ans);
        if(node.right!=null) addLeaves(node.right,ans);
    }

    private void addRightBoundary(TreeNode node, List<Integer> ans){
        TreeNode cur = node.right;
        List<Integer> tempAns = new ArrayList<>();

        while(cur!=null){
            if(!isLeaf(cur)) tempAns.add(cur.data);
            if(cur.right!=null) cur = cur.right;
            else cur=cur.left;
        }

        List<Integer> reversed = tempAns.reversed();

        ans.addAll(reversed);
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,null,new TreeNode(7)));
        test.left.left.right = new TreeNode(5,new TreeNode(6),new TreeNode(7));
        test.right.right.left = new TreeNode(9,new TreeNode(10),new TreeNode(11));

        BoundaryTraversal bt = new BoundaryTraversal();
        List<Integer> ans = bt.printBoundary(test);

        ans.stream().forEach(System.out::println);
    }
}
