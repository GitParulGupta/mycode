package com.example.practice.code.binarytrees;

import java.util.*;


/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
 * Return the vertical order traversal of the binary tree.
 */
public class VerticalOrderTraversal {

    private List<List<Integer>> solution(TreeNode test) {

        //TreeMap<Vertical, TreeMap<level, PriorityQueue<Integer>>> map = new TreeMap<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(test,0,0));

        while(!q.isEmpty()){

            Tuple temp = q.poll();
            TreeNode tempNode = temp.node;
            int x = temp.row;
            int y = temp.col;

            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(tempNode.data);

            if(tempNode.left!=null)q.offer(new Tuple(tempNode.left,x-1,y+1));
            if(tempNode.right!=null)q.offer(new Tuple(tempNode.right,x+1,y+1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> treeMap: map.values()){

            List<Integer> tempList = new ArrayList<>();

            for(PriorityQueue<Integer> pq:treeMap.values()){
                while(!pq.isEmpty()){
                    tempList.add(pq.poll());
                }
            }

            ans.add(tempList);
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
         *      Vertical Order
         *
         *      {{4,6},{2,5},{1,7,10}{3,9},{7,11}}
         *      Node if 2 nodes are the same coordinates - they should be stored in ascending order
         */
        TreeNode test = new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,null,new TreeNode(7)));
        test.left.left.right = new TreeNode(5,new TreeNode(6),new TreeNode(7));
        test.right.right.left = new TreeNode(9,new TreeNode(10),new TreeNode(11));

        VerticalOrderTraversal vot = new VerticalOrderTraversal();
        List<List<Integer>> ans = vot.solution(test);

        ans.stream().forEach(
                l-> {
                    l.stream().forEach(System.out::println);
                            System.out.print("\n");
                });
    }

}

class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
