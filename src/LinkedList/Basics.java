package LinkedList;

import java.util.*;

class Basics {

    public static void main(String args[])
    {
        Node head=new Node(1);
        head.next=new Node(1);
        head.next.next=new Node(2);
        head.next.next.next=new Node(1);
        if(isPalindrome(head))
            System.out.print("Yes");
        else
            System.out.print("No");

    }

    static Node reverseList(Node head){
        if(head==null||head.next==null)
            return head;

        Node rest_head=reverseList(head.next);
        Node rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;
        
        return rest_head;
    }

    static boolean isPalindrome(Node head){
        if(head==null)return true;
        Node slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node rev=reverseList(slow.next);
        Node curr=head;
        while(rev!=null){
            if(rev.data!=curr.data)
                return false;
            rev=rev.next;
            curr=curr.next;
        }
        return true;
    }
}