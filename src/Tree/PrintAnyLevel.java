package Tree;

import java.util.ArrayList;

public class PrintAnyLevel {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);

        ArrayList<Integer> a = new ArrayList<Integer>();
        printgivenlevel(2, a, root);

        System.out.println(a.size());
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void printgivenlevel(int level, ArrayList<Integer> a, Node root) {
        if (root != null) {
            if (level == 0) {
                a.add(root.value);
            }
            printgivenlevel(level - 1, a, root.left);
            printgivenlevel(level - 1, a, root.right);
        }

    }
}
