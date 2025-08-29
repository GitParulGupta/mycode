package com.example.practice.code.binarytrees;

import java.util.*;

/**
 * DFS
 * *****Pre Order
 * *****InOrder
 * ***** Post Order
 *
 * BFS
 * ****Level Order
 */
public class Traversals {

    private static final String FORWARD ="forward";
    private static final String BACKWARD ="backward";

    //root, left, right
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrderTraversalHelper(ans,root);
        return ans;
    }

    private void preOrderTraversalHelper(List<Integer> l, TreeNode root){
        if(root==null){
            return;
        }
        l.add(root.data);
        preOrderTraversalHelper(l,root.left);
        preOrderTraversalHelper(l,root.right);
    }

    public List<Integer> preorderTraversalIterative(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if(node==null) return ans;

        Stack<TreeNode> stack= new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            ans.add(temp.data);
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
        }
        return ans;
    }

    //left,root, right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalHelper(ans,root);
        return ans;
    }

    private void inorderTraversalHelper(List<Integer> l, TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversalHelper(l,root.left);
        l.add(root.data);
        inorderTraversalHelper(l,root.right);
    }

    public List<Integer> inorderTraversalIterative(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if(node==null) return ans;

        Stack<TreeNode> stack= new Stack<>();

        TreeNode tempNode = node;

        while (true){
            if(tempNode!=null){
                stack.push(tempNode);
                tempNode = tempNode.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                tempNode = stack.pop();
                ans.add(tempNode.data);
                tempNode = tempNode.right;
            }
        }
        return ans;
    }

    //left,right, root
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversalHelper(ans,root);
        return ans;
    }

    private void postorderTraversalHelper(List<Integer> l, TreeNode root){
        if(root==null){
            return;
        }
        postorderTraversalHelper(l,root.left);
        postorderTraversalHelper(l,root.right);
        l.add(root.data);
    }

    public List<Integer> postorderTraversalIterative(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if(node==null) return ans;

        Stack<TreeNode> stack= new Stack<>();
        Stack<TreeNode> stackAns= new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            stackAns.push(temp);
            if(temp.left!=null )stack.push(temp.left);
            if(temp.right!=null )stack.push(temp.right);
        }

        while (!stackAns.isEmpty()){
            ans.add(stackAns.pop().data);
        }
        return ans;
    }

    /**
     * Rules -
     * if traversalCount == 1
     * preOrder
     * traversalCount++
     * stack.add leftnode,1
     * if traversalCount == 2
     *      * inOrder
     *      * traversalCount++
     *      * stack.add right,1
     * if traversalCount == 3
     *      * postOrder
     *
     * @param root
     * @return
     */
    public List<List<Integer>> allTraversal(TreeNode root){

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        ans.add(preOrder);
        ans.add(inOrder);
        ans.add(postOrder);

        Stack<TreeNodeTraversalCount> stack = new Stack<>();
        stack.push(new TreeNodeTraversalCount(root,1));

        while(!stack.isEmpty()){
            TreeNodeTraversalCount temp = stack.pop();

            if(temp.getTraversalCount()==1){
                preOrder.add(temp.getNode().data);
                int curCount = temp.getTraversalCount();
                temp.setTraversalCount(curCount+1);
                stack.push(temp);
                if(temp.getNode().left!=null){
                    stack.push(new TreeNodeTraversalCount(temp.getNode().left,1));
                }
            }else if(temp.getTraversalCount()==2){
                inOrder.add(temp.getNode().data);
                int curCount = temp.getTraversalCount();
                temp.setTraversalCount(curCount+1);
                stack.push(temp);
                if(temp.getNode().right!=null){
                    stack.push(new TreeNodeTraversalCount(temp.getNode().right,1));
                }
            }else if(temp.getTraversalCount()==3){
                postOrder.add(temp.getNode().data);
            }
        }

        return ans;
    }

    public List<Integer> levelOrderTraversal(TreeNode node){
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        treeNodeQueue.add(node);
        List<Integer> result = new ArrayList<>();

        while(!treeNodeQueue.isEmpty()){
            TreeNode temp = treeNodeQueue.remove();
            result.add(temp.data);
            if(temp.left!=null){
                treeNodeQueue.add(temp.left);
            }
            if(temp.right!=null){
                treeNodeQueue.add(temp.right);
            }
        }

        return result;

    }

    public List<List<Integer>> levelOrderTraversalGroupByLevel(TreeNode node){
        List<List<Integer>> result = new ArrayList<>();
       if(node==null){
           return result;
       }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
       treeNodeQueue.add(node);

       while(!treeNodeQueue.isEmpty()){
           int levelSize = treeNodeQueue.size();

           List<Integer> tempList = new ArrayList<>();

           for(int i=0;i<levelSize;i++){
               TreeNode temp = treeNodeQueue.poll();
               tempList.add(temp.data);
               if(temp.left!=null) treeNodeQueue.add(temp.left);
               if(temp.right!=null) treeNodeQueue.add(temp.right);
           }
           
           result.add(tempList);
       }
        return result;
    }

    public List<List<Integer>> levelOrderTraversalSpiral(TreeNode node){
        List<List<Integer>> result = new ArrayList<>();
        if(node==null){
            return result;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(node);

        String direction = FORWARD;
        while(!treeNodeQueue.isEmpty()){
            int levelSize = treeNodeQueue.size();

            List<Integer> tempList = new ArrayList<>();

            for(int i=0;i<levelSize;i++){
                TreeNode temp = treeNodeQueue.poll();
                tempList.add(temp.data);
                if(temp.left!=null) treeNodeQueue.add(temp.left);
                if(temp.right!=null) treeNodeQueue.add(temp.right);
            }

            if(tempList.size()>1){
                if(BACKWARD.equals(direction)){
                    tempList = tempList.reversed();
                    direction = FORWARD;
                }else{
                    direction = BACKWARD;
                }
            }
            result.add(tempList);
        }
        return result;
    }

    public static void main(String[] args) {
        Traversals obj = new Traversals();


        /**
         *              2
         *         1       3
         *       X   4   5    6
         *
         * X --> null
         */
        TreeNode root = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<Integer> preOrder = obj.preorderTraversal(root);
        System.out.println("Preorder");
        preOrder.forEach(System.out::println); //2 1 4 3 5 6

        List<Integer> preOrderIterative = obj.preorderTraversalIterative(root);
        System.out.println("preOrderIterative");
        preOrderIterative.forEach(System.out::println); //2 1 4 3 5 6

        List<Integer> inOrder = obj.inorderTraversal(root);
        System.out.println("Inorder");
        inOrder.forEach(System.out::println); // 1 4 2 5 3 6

        List<Integer> inOrderIterative = obj.inorderTraversalIterative(root);
        System.out.println("inOrderIterative");
        inOrderIterative.forEach(System.out::println); //1 4 2 5 3 6

        List<Integer> postOrder = obj.postorderTraversal(root);
        System.out.println("postorder");
        postOrder.forEach(System.out::println); // 4 1 5 6 3 2

        List<Integer> postOrderIterative = obj.postorderTraversalIterative(root);
        System.out.println("postOrderIterative");
        postOrderIterative.forEach(System.out::println); //4 1 5 6 3 2

        List<Integer> levelOrder = obj.levelOrderTraversal(root);
        System.out.println("level");
        levelOrder.forEach(System.out::println); // 2 1 3 4 5 6

        List<List<Integer>> levelOrderGroupedByLevel = obj.levelOrderTraversalGroupByLevel(root);
        System.out.println("levelOrderbyLevel");
        for(List<Integer> l:levelOrderGroupedByLevel){
            l.forEach(System.out::print);
            System.out.print("\n");
        }

        List<List<Integer>> levelOrderSpiral = obj.levelOrderTraversalSpiral(root);
        System.out.println("levelOrderSpiral");
        for(List<Integer> l:levelOrderSpiral){
            l.forEach(System.out::print);
            System.out.print("\n");
        }

        List<List<Integer>> allTraversal = obj.allTraversal(root);
        System.out.println("allTraversal");
        for(List<Integer> l:allTraversal){
            l.forEach(System.out::print);
            System.out.print("\n");
        }

    }
}

class TreeNodeTraversalCount{
    private TreeNode node;
    private int traversalCount;

    public TreeNodeTraversalCount(TreeNode node, int traversalCount) {
        this.node = node;
        this.traversalCount = traversalCount;
    }

    public void setTraversalCount(int traversalCount) {
        this.traversalCount = traversalCount;
    }

    public TreeNode getNode() {
        return node;
    }

    public int getTraversalCount() {
        return traversalCount;
    }
}
