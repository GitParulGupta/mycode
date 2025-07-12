package com.example.practice.code.stackandqueues;

public class QueueUsingLL {

    static ListNode head = null;

    ListNode add(int a){
        if(head==null){
            head = new ListNode(a);
            return head;
        }

        ListNode temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = new ListNode(a);
        return head;
    }

    int remove(){
        if(head==null){
            System.out.println("Queue is empty");
            return -1;
        }
        int res = head.val;
        head = head.next;

        return res;
    }

    int peek(){
        if(head==null){
            System.out.println("Queue is empty");
            return -1;
        }

        return head.val;
    }

    int size(){
        if(head==null){
            System.out.println("Queue is empty");
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
        String[] operation = {"add","add","add","remove","remove","remove","peek","remove","add"};
        int[] num = {0,1,3,-1,-1,-1,-1,-1,2};
        QueueUsingLL obj = new QueueUsingLL();

        for(int i=0;i<operation.length;i++){
            try {
                switch (operation[i]){
                    case "add":
                        head = obj.add(num[i]);
                        System.out.println("Added element: "+num[i]);
                        break;
                    case "peek":
                        System.out.println(operation[i]+ " " + obj.peek());
                        break;
                    case "remove":
                        System.out.println(operation[i]+ " " + obj.remove());
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
