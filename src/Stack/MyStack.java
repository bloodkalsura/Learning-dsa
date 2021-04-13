package Stack;

class Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}
class MyStack {
    Node head;
    int size;
    MyStack(){
        head=null;
        size=-1;
    }

    int Size(){
        return size;
    }

    boolean isEmpty(){
        return head==null;
    }

    void push(int a){
        Node temp=new Node(a);
        temp.next=head;
        head=temp;
        size++;
    }

    int pop(){
        if(head==null)
            return Integer.MAX_VALUE;
        int res=head.data;
        head=head.next;
        size--;
        return res;
    }

    int peek(){
        if(head==null)
            return Integer.MAX_VALUE;
        return head.data;
    }

    public static void main (String[] args)
    {
        MyStack s=new MyStack();
        s.push(5);
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.Size());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
    }
}





