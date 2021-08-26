package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);

        view(root);
    }

    public static void view(Node root)
    {
        if(root.left==null && root.right==null)
        {
            System.out.println(root.value);
            return;
        }

        Queue<Node> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int count=q.size();

            for(int i=0;i<count;i++)
            {
                Node cur=q.poll();

                if(i==0)
                    System.out.print(cur.value+" ");

                if(cur.left!=null)
                    q.offer(cur.left);

                if(cur.right!=null)
                    q.offer(cur.right);

            }
        }
    }
}
