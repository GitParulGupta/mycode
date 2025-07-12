package com.example.practice.code.stackandqueues;

public class StackUsingLL {

    static ListNode head = null;

    ListNode push(int a){
        head = new ListNode(a,head);
        return head;
    }

    int pop(){
        if(head==null){
            System.out.println("Stack is empty");
            return -1;
        }
        int res = head.val;
        head = head.next;

        return res;
    }

    int top(){
        if(head==null){
            System.out.println("Stack is empty");
            return -1;
        }

        return head.val;
    }

    int size(){
        if(head==null){
            System.out.println("Stack is empty");
            return -1;
        }
        int size = 1;
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            size++;
        }

        return size;
    }



    public static void main(String[] args) {
        String[] operation = {"push","push","push","pop","pop","pop","top","pop","push"};
        int[] num = {0,1,3,-1,-1,-1,-1,-1,2};
        StackUsingLL obj = new StackUsingLL();

        for(int i=0;i<operation.length;i++){
            try {
                switch (operation[i]){
                    case "push":
                        head = obj.push(num[i]);
                        System.out.println("Added element: "+num[i]);
                        break;
                    case "top":
                        System.out.println(operation[i]+ " " + obj.top());
                        break;
                    case "pop":
                        System.out.println(operation[i]+ " " + obj.pop());
                        break;
                    default:
                        System.out.println("Invalid operation");
                }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }


}


class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
