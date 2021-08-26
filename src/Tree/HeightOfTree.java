package Tree;

public class HeightOfTree {

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);

        System.out.println("Height of Tree "+height(root));
    }

    public static int height(Node root)
    {
        if(root==null)
            return 0;

        return Math.max(height(root.left),height(root.right))+1;
    }
}
