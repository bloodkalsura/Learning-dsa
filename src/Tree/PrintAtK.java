package Tree;

import java.util.ArrayList;

public class PrintAtK {
    static ArrayList<Integer> a=new ArrayList<Integer>();

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);

        int k=2;
        KDistance(root,k);
        System.out.println(a);
    }

    public static void KDistance(Node root, int k)
    {
        if(root==null)
            return;
        if(k==0)
        {
            System.out.println(root.value);
            a.add(root.value);
        }
        else
                KDistance(root.left,k-1);
                KDistance(root.right,k-1);
    }
}
