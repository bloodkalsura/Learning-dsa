package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumInTree {

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);

        System.out.println("Maximum in Tree "+maximum(root));
    }

    public static int maximum(Node root)
    {
        if(root==null)
            return 0;

        Queue<Node> q=new LinkedList<>();
        int max=-1;

        q.add(root);

        while(!q.isEmpty())
        {
            Node cur=q.poll();
            max=Math.max(cur.value,max);

            if(cur.left!=null)
                q.add(cur.left);


            if(cur.right!=null)
                q.add(cur.right);
        }
        return max;
    }
}