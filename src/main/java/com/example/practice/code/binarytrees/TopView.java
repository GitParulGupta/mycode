package com.example.practice.code.binarytrees;

import java.util.*;


/**
 * Given the root of a binary tree, return the top view of the binary tree.
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
 * Return nodes from the leftmost node to the rightmost node.
 * Also if 2 nodes are outside the shadow of the tree and are at the same position then consider the left ones only(i.e. leftmost).
 * TC & SC -->O(N)
 */
public class TopView {

    private List<Integer> solution(TreeNode test) {

        //TreeMap<Vertical, TreeMap<level, Integer>>> map = new TreeMap<>();
        TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(test,0,0));

        while(!q.isEmpty()){

            Tuple temp = q.poll();
            TreeNode tempNode = temp.node;
            int x = temp.row;
            int y = temp.col;

            if(!map.containsKey(x)){
                TreeMap<Integer,Integer> m=new TreeMap<>();
                m.put(y, tempNode.data);
                map.put(x,m);
            }

            if(tempNode.left!=null)q.offer(new Tuple(tempNode.left,x-1,y+1));
            if(tempNode.right!=null)q.offer(new Tuple(tempNode.right,x+1,y+1));
        }

        List<Integer> ans = new ArrayList<>();

        for(TreeMap<Integer,Integer> treeMap: map.values()){

            List<Integer> tempList = treeMap.values().stream().toList();
            ans.addAll(tempList);
        }
        return ans;
    }

    public static void main(String[] args) {

        /**
         *          1
         *        2   3
         *      4       7
         *        5   9
         *      6  710  11
         *
         *      Top View
         *      {4,2,1,3,7}
         *      Node if 2 nodes are the same coordinates - they should be stored in ascending order
         */
        TreeNode test = new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,null,new TreeNode(7)));
        test.left.left.right = new TreeNode(5,new TreeNode(6),new TreeNode(7));
        test.right.right.left = new TreeNode(9,new TreeNode(10),new TreeNode(11));

        TopView vot = new TopView();
        List<Integer> ans = vot.solution(test);

        ans.stream().forEach(System.out::println);
    }

}

