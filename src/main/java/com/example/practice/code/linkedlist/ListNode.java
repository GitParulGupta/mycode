package com.example.practice.code.linkedlist;

public class ListNode {

    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }

    ListNode(int data, ListNode next){
        this.data = data;
        this.next = next;
    }

    public boolean hasNext(){
        return this.next != null;
    }

}
