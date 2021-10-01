package LinkedList;

public class DeleteWithoutHeadPointer {

    public static void DeleteWithoutHead(Node point)
    {
        point.data=point.next.data;
        point.next=point.next.next;
    }
}
