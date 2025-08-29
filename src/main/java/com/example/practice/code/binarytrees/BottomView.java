package com.example.practice.code.binarytrees;

import java.util.*;


/**
 * Given root of binary tree, return the bottom view of the binary tree.
 * The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.
 * Return nodes from the leftmost node to the rightmost node. Also if 2 nodes are outside the shadow of the tree and
 * are at the same position then consider the node that appears later in level traversal.
 * TC & SC -->O(N)
 */
public class BottomView {

    private List<Integer> solution(TreeNode test) {

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(test,0,0));

        while(!q.isEmpty()){

            Tuple temp = q.poll();
            TreeNode tempNode = temp.node;
            int x = temp.row;
            int y = temp.col;

            if(!map.containsKey(x)){
                map.put(x,List.of(tempNode.data));
            }
            List<Integer> tempList = new ArrayList<>(map.get(x));
            tempList.add(tempNode.data);
            map.put(x,tempList);

            if(tempNode.left!=null)q.offer(new Tuple(tempNode.left,x-1,y+1));
            if(tempNode.right!=null)q.offer(new Tuple(tempNode.right,x+1,y+1));
        }

        List<Integer> ans = new ArrayList<>();

        for(List<Integer> l: map.values()){
            ans.add(l.getLast());
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
         *      Bottom View
         *      {6,5,7,10,9,11}
         *      Node if 2 nodes are the same coordinates - rightmost node is gven pref
         */
        TreeNode test = new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,null,new TreeNode(7)));
        test.left.left.right = new TreeNode(5,new TreeNode(6),new TreeNode(7));
        test.right.right.left = new TreeNode(9,new TreeNode(10),new TreeNode(11));

        BottomView vot = new BottomView();
        List<Integer> ans = vot.solution(test);

        ans.stream().forEach(System.out::println);
    }

}

