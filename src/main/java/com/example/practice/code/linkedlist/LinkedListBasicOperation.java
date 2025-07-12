package com.example.practice.code.linkedlist;

public class LinkedListBasicOperation {

    public ListNode arrayToLinkedList(int[] input){

        ListNode head = null;
        ListNode current = null;

        for(int i:input){

            if(current==null){
                current = new ListNode(i);
                head =current;
            }else{
                ListNode newNode = new ListNode(i);
                current.next = newNode;
                current = newNode;
            }
        }
        return head;
    }

    public int lengthOfLinkedList(ListNode head){
        int count = 0;

        ListNode temp = head;

        while(temp !=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean searchElement(ListNode head, int target){

        ListNode temp = head;

        while(temp !=null){
            if(temp.data==target){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void printLinkedList(ListNode head){
        ListNode printNode = head;
        while(printNode!=null){
            System.out.println("Current:"+printNode.data);
            printNode = printNode.next;
        }
    }

    /**
     * Inert given data element after given position element. If the position element does not exist, add element at the end
     * @param data
     */
    public ListNode insertElement(ListNode head, int data, int position){
        ListNode temp = head;
        boolean inserted = false;
        while(temp.hasNext()){
            if(temp.data==position){
                ListNode nextNode = temp.next;
                temp.next = new ListNode(data,nextNode);
                inserted = true;
                break;
            }
            temp = temp.next;
        }

        if(!inserted){
            temp.next = new ListNode(data);
        }

        return head;
    }

    public ListNode deleteElement(ListNode head, int data){
        ListNode current = head;

        if(current.data==data){
            head = head.next;
            return head;
        }

        while(current.next!=null){
            if(current.next.data==data){
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }

        if(current.data==data){
            current = null;
        }

        return head;
    }

    public ListNode reverseList(ListNode head){
        ListNode current = head;

        ListNode prev = null;
        ListNode front = null;

        while(current!=null){
            front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }

        return prev;
    }


    public static void main(String[] args) {
        int[] input = {0,3,1,2};

        LinkedListBasicOperation obj = new LinkedListBasicOperation();

        ListNode ans = obj.arrayToLinkedList(input);

        obj.printLinkedList(ans);

        System.out.println("LinkedList size:"+obj.lengthOfLinkedList(ans));

        System.out.println("Find element 3:"+obj.searchElement(ans,3));
        System.out.println("Find element 4:"+obj.searchElement(ans,4));

        System.out.println("Insert element 4 after 3:");
        ListNode newList = obj.insertElement(ans,4,3);
        obj.printLinkedList(newList);

        System.out.println("Insert element 5 after 6:");
        ListNode newList1 = obj.insertElement(ans,5,6);
        obj.printLinkedList(newList1);

        System.out.println("Delete element 0");
        ListNode newList2 = obj.deleteElement(ans,0);
        obj.printLinkedList(newList2);

        System.out.println("Delete element 3");
        ListNode newList3 = obj.deleteElement(ans,3);
        obj.printLinkedList(newList3);

        System.out.println("Delete element 5");
        ListNode newList4 = obj.deleteElement(ans,5);
        obj.printLinkedList(newList4);

    }

}
