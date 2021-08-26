package Tree;
import java.util.*;


class Traversal {

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);

        InorderTraversal(root);
        System.out.println();
        PreorderTraversal(root);
        System.out.println();
        PostorderTraversal(root);

    }

    public static void InorderTraversal(Node root) {

        if(root!=null)
        {
            InorderTraversal(root.left);
            System.out.print(root.value+" ");
            InorderTraversal(root.right);
        }
    }

    public static void PreorderTraversal(Node root) {
        if(root!=null)
        {
            System.out.print(root.value+" ");
            PreorderTraversal(root.left);
            PreorderTraversal(root.right);
        }
    }

    public static void PostorderTraversal(Node root) {

        if(root!=null)
        {
            PostorderTraversal(root.left);
            PostorderTraversal(root.right);
            System.out.print(root.value+" ");
        }
    }
}