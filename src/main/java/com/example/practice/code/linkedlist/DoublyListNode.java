package com.example.practice.code.linkedlist;

public class DoublyListNode {

    int data;
    DoublyListNode next;
    DoublyListNode previous;

    public DoublyListNode(int data, DoublyListNode next, DoublyListNode previous){
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public DoublyListNode(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

}
