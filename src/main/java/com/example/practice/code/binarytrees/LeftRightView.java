package com.example.practice.code.binarytrees;

import java.util.*;


/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * TC & SC -->O(N)
 */
public class LeftRightView {

    private List<Integer> rightSolution(TreeNode test) {

        List<Integer> ans = new ArrayList<>();
        if(test==null) return ans;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        Queue<PairTreeNode> q = new LinkedList<>();
        q.offer(new PairTreeNode(test,0));

        while(!q.isEmpty()){

            PairTreeNode temp = q.poll();
            TreeNode tempNode = temp.node;
            int level = temp.level;

            if(!map.containsKey(level)){
                map.put(level,List.of(tempNode.data));
            }
            List<Integer> tempList = new ArrayList<>(map.get(level));
            tempList.add(tempNode.data);
            map.put(level,tempList);

            if(tempNode.left!=null)q.offer(new PairTreeNode(tempNode.left,level+1));
            if(tempNode.right!=null)q.offer(new PairTreeNode(tempNode.right,level+1));
        }

        for(List<Integer> l: map.values()){
            ans.add(l.getLast());
        }
        return ans;
    }

    private List<Integer> leftSolution(TreeNode test) {

        List<Integer> ans = new ArrayList<>();
        if(test==null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<PairTreeNode> q = new LinkedList<>();
        q.offer(new PairTreeNode(test,0));

        while(!q.isEmpty()){

            PairTreeNode temp = q.poll();
            TreeNode tempNode = temp.node;
            int level = temp.level;

            if(!map.containsKey(level)){
                map.put(level, tempNode.data);
            }

            if(tempNode.left!=null)q.offer(new PairTreeNode(tempNode.left,level+1));
            if(tempNode.right!=null)q.offer(new PairTreeNode(tempNode.right,level+1));
        }

        for(Integer e: map.values()){
            ans.add(e);
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
         *      Right View
         *      {1,3,7,9,11}
         *
         *      Left View
         *      {1,2,4,5,6}
         *      Node if 2 nodes are the same coordinates - rightmost node is gven pref
         */
        TreeNode test = new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,null,new TreeNode(7)));
        test.left.left.right = new TreeNode(5,new TreeNode(6),new TreeNode(7));
        test.right.right.left = new TreeNode(9,new TreeNode(10),new TreeNode(11));

        LeftRightView vot = new LeftRightView();
        List<Integer> ansRight = vot.rightSolution(test);
        ansRight.forEach(System.out::println);

        List<Integer> ansLeft = vot.leftSolution(test);
        ansLeft.forEach(System.out::println);
    }

}

class PairTreeNode{
    TreeNode node;
    int level;

    public PairTreeNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
