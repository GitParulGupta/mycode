package com.example.practice.code.linkedlist;


import java.util.Stack;

/***
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 * Custom Judge:
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 */
public class IntersectionLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA!=null){
            stackA.push(tempA);
            tempA=tempA.next;
        }

        while(tempB!=null){
            stackB.push(tempB);
            tempB=tempB.next;
        }

        ListNode result = null;

        while (!stackA.isEmpty() && !stackB.isEmpty()){
            ListNode l1 = stackA.pop();
            ListNode l2 = stackB.pop();

            if(l1==l2){
                result= l1;
            }
        }

        return result;
    }

}
