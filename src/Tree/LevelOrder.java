package Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);
        traverse(root);

    }
    public static int height(Node root){
        if(root==null)
            return 0;

        return Math.max(height(root.left),height(root.right))+1;
    }
    public static  void printgivenlevel(int level, ArrayList<Integer> a, Node root)
    {
        if(root!=null){
            if(level == 0){
                a.add(root.value);
            }
            printgivenlevel(level-1, a, root.left);
            printgivenlevel(level-1, a, root.right);
        }

    }

    public static void traverse(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int count=q.size();

            for(int i=0;i<count;i++)
            {
                Node cur=q.poll();
                System.out.print(cur.value+" ");

                if(cur.left!=null)
                    q.offer(cur.left);

                if(cur.right!=null)
                    q.offer(cur.right);

            }
            System.out.println();
        }
    }
}
