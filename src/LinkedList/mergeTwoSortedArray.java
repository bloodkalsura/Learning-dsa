package LinkedList;

public class mergeTwoSortedArray {
    Node mergeArray(Node a,Node b){
        if(a==null)return b;
        if(b==null)return a;

        Node tail=null,head=null;

        if(a.data>=b.data){
            tail=head=b;
            b=b.next;
        }else{
            tail=head=a;
            a=a.next;
        }

        while(a!=null&&b!=null){
            if(a.data>=b.data){
                tail.next=b;
                tail=b;
                b=b.next;
            }else{
                tail.next=a;
                tail=a;
                a=a.next;
            }
        }
        if(a==null)
            tail.next=b;
        else
            tail.next=a;

        return head;
    }
}
