package com.example.practice.code.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CyclicLinkedList {

    public ListNode createCyclicLinkedList(int[] a){

        Map<Integer,ListNode> map = new HashMap<>();

        ListNode head = null;
        ListNode current = null;

        for(int i : a){

            if(current==null){
                ListNode headNode = new ListNode(i);
                map.put(i,headNode);
                current = headNode;
            }

            if(map.containsKey(i)){
                current.next = map.get(i);

            }else {
                ListNode temp = new ListNode(i);
                map.put(i,temp);
                current.next = temp;
            }
            current = current.next;
        }

        return head;

    }

    public boolean detectCyclic(ListNode head){
        Set<ListNode> nodeSet = new HashSet<>();

        ListNode temp = head;

        while(temp!=null){
            if(temp.next !=null && nodeSet.contains(temp.next)){
                return true;
            }else{
                nodeSet.add(temp);
            }
            temp =temp.next;
        }

        return false;
    }

    public ListNode cycleStartNode(ListNode head){
        Map<ListNode,Integer> nodeMap = new HashMap<>();

        ListNode temp = head;
        int count = 0;

        while(temp!=null){
            if(temp.next !=null && nodeMap.containsKey(temp.next)){
                return temp.next;
            }else{
                nodeMap.put(temp,count);
            }
            temp =temp.next;
            count++;
        }

        return null;
    }

    public int cycleLength(ListNode head){
        Map<ListNode,Integer> nodeMap = new HashMap<>();

        ListNode temp = head;
        int count = 0;

        while(temp!=null){
            if(temp.next !=null && nodeMap.containsKey(temp.next)){
                return count-nodeMap.get(temp.next)+1;
            }else{
                nodeMap.put(temp,count);
            }
            temp =temp.next;
            count++;
        }

        return 0;
    }

    public static void main(String[] args) {

        CyclicLinkedList obj = new CyclicLinkedList();

        int[] a = {3,2,1,4,2};

        ListNode ans = obj.createCyclicLinkedList(a);

        System.out.println(obj.cycleLength(ans));

    }

}
