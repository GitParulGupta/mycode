package com.example.practice.code.linkedlist;

public class DoublyLinkedListBasicOp {

    public DoublyListNode convertArrayToDll(int[] a){

        DoublyListNode current = null;
        DoublyListNode head = null;

        for(int i:a){
            if(head==null){
                head = new DoublyListNode(i);
                current = head;
            }else{
                DoublyListNode newNode = new DoublyListNode(i);
                current.next = newNode;
                newNode.previous = current;
                current = newNode;
            }
        }
        return head;
    }

    public void printDLL(DoublyListNode head){

        DoublyListNode temp = head;

        while(temp!=null){
            System.out.print("Current:" + temp.data);

            if(temp.next!=null){
                System.out.print (" Next:" +temp.next.data);
            }

            if(temp.previous!=null){
                System.out.print(" Previous:" +temp.previous.data);
            }
            System.out.println();

            temp = temp.next;
        }
    }

    public void printDLLReverse(DoublyListNode head){
        DoublyListNode temp = head;

        while(temp.next!=null){
            temp = temp.next;
        }

        while(temp!=null){
            System.out.print("Current:" + temp.data);

            if(temp.next!=null){
                System.out.print (" Next:" +temp.next.data);
            }

            if(temp.previous!=null){
                System.out.print(" Previous:" +temp.previous.data);
            }
            System.out.println();

            temp = temp.previous;
        }

    }

    public DoublyListNode insertNode(DoublyListNode head, int data, int position){
        DoublyListNode temp = head;
        if(head.data==position){
            DoublyListNode newNode= new DoublyListNode(data,head,null);
            head.previous = newNode;
            return newNode;
        }
        boolean inserted = false;
        while(temp!=null){
            if(temp.data==position){
                inserted = true;
                temp.next = new DoublyListNode(data,temp.next,temp);
                break;
            }
            temp = temp.next;
        }

        if(!inserted){
            DoublyListNode temp2 = head;
            while(temp2.next!=null){
                temp2 = temp2.next;
            }
            temp2.next = new DoublyListNode(data,null,temp2);
        }

        return head;
    }

    public DoublyListNode deleteNode(DoublyListNode head, int position){
        DoublyListNode temp = head;
        if(head.data==position){
            head = head.next;
            return head;
        }
        while(temp!=null){
            if(temp.data==position){
                temp.previous.next = temp.next;
                if(temp.next!=null){
                    temp.next.previous = temp.previous.previous;
                }
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    /**
     * Perform by storing last element. at each step swap previous and next for the current element
     * @param head
     * @return
     */
    public DoublyListNode reverseDll(DoublyListNode head){
        DoublyListNode current = head;

        DoublyListNode last = null;

        while(current!=null){
            last = current.previous;
            current.previous = current.next;
            current.next = last;
            current = current.previous; //links have reversed for current node
        }

        //which node to return as head
        return last.previous;
    }


    public static void main(String[] args) {

        int[] input = {0,3,2,1,8};

        DoublyLinkedListBasicOp obj = new DoublyLinkedListBasicOp();

        System.out.println("\nConverted List from Array");
        DoublyListNode ans = obj.convertArrayToDll(input);
        obj.printDLL(ans);

        System.out.println("\nList printed in reverse order");
        obj.printDLLReverse(ans);

        System.out.println("\nInsert 5 after 1, Result: 0 3 2 1 5 8");
        ans = obj.insertNode(ans,5,1);
        obj.printDLL(ans);

        System.out.println("\nInsert 11 before 0, Result: 11 0 3 2 1 5 8");
        ans  = obj.insertNode(ans,11,0);
        obj.printDLL(ans);

        System.out.println("\nInsert 12 after 8, Result: 11 0 3 2 1 5 8 12");
        ans  = obj.insertNode(ans,12,8);
        obj.printDLL(ans);

        System.out.println("\nInsert 13 after 6, Result: 11 0 3 2 1 5 8 12 13");
        ans  = obj.insertNode(ans,13,6);
        obj.printDLL(ans);


        System.out.println("\nDelete 11, Result: 0 3 2 1 5 8 12 13");
        ans  = obj.deleteNode(ans,11);
        obj.printDLL(ans);

        System.out.println("\nDelete 2, Result: 0 3 1 5 8 12 13");
        ans  = obj.deleteNode(ans,2);
        obj.printDLL(ans);

        System.out.println("\nDelete 13, Result: 0 3 1 5 8 12");
        ans  = obj.deleteNode(ans,13);
        obj.printDLL(ans);


        System.out.println("Reversing DLL");
        DoublyListNode copyList = ans;
        copyList = obj.reverseDll(copyList);
        obj.printDLL(copyList);

    }
}
