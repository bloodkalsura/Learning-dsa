package LinkedList;

class Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}

public class PrintList {
    public static void print(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"-->");
            curr=curr.next;
        }System.out.println();
    }

    public static Node addFirst(Node head, int a){
       Node temp=new Node(a);
       temp.next=head;
       return temp;

    }

    public static Node deleteFirst(Node head){
        head=head.next;
        return head;
    }

    public static Node deleteLast(Node head){
        Node current=head;
        while(current.next.next!=null)
            current=current.next;

        current.next=null;

        return head;
    }

    public static Node insertAtGivenPos(Node head,int pos,int data){
        Node temp=new Node(data);
        Node current=head;
        int index=0;
        while (index<pos-1){
            current=current.next;
            index++;
        }
        temp.next=current.next;
        current.next=temp;

        return head;
    }

    public static int search(Node head,int x){
        int index=0;
        Node current=head;
        while (current!=null){
            if(current.data==x)
                return index;
            else {
                index++;
                current=current.next;
            }
        }
        return -1;
    }

    public static void printMiddle(Node head){
        if(head==null||head.next==null)
            System.out.println(head);;
        Node slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println("The Middle Element is "+slow.data);
    }

    public static Node addLast(Node head, int a){
        Node temp=new Node(a);
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=temp;

        return head;
    }

    public static Node reverseLinkedList(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        Node head=new Node(34);
        Node temp1=new Node(67);
        Node temp2=new Node(78);
        Node temp3=new Node(69);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;

        print(head);
        head=addFirst(head,23);
        print(head);
        head=addLast(head,67);
        print(head);
        head=deleteFirst(head);
        print(head);
        head=deleteLast(head);
        print(head);
        head=insertAtGivenPos(head,3,98);
        print(head);
        System.out.println("The Element is at index position : "+search(head,67));
        printMiddle(head);
        head=reverseLinkedList(head);
        print(head);
    }
}
