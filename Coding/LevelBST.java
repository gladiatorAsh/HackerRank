
import java.awt.List;

import java.util.*;

import com.sun.glass.ui.Window.Level;

public class LevelBST {

    public class Node {
        int val;
        Node left;
        Node right;

        public Node(int temp) {
            val = temp;
        }
    }

    public void Print3(Node root) {
        // Prints nth node from last in all level except root.
        // For n=1, root gets printed. But for others print separately

        int n = 2;
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {

                int size = queue.size();
                while (size > 0) {

                    Node temp = queue.poll();

                    if (size == n) {
                        System.out.println(temp.val);
                    }

                    if (temp.left != null) {
                        queue.add(temp.left);
                    }

                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                    size--;
                }
            }
        }
    }

    public void Print1(Node root) {
        if (root != null) {

            Queue<Node> queue = new LinkedList<Node>();
            Node newLineNode = new Node(Integer.MIN_VALUE);
            queue.add(root);
            queue.add(newLineNode);
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                if (temp == newLineNode) {
                    System.out.println("");
                    if (!queue.isEmpty()) {
                        queue.add(newLineNode);
                    }
                } else {
                    System.out.print(temp.val + " ");
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
        }
    }

    public void Print2(Node root) {
        if (root != null) {

            LinkedList<Node> temp = new LinkedList<>();
            temp.add(root);
            while (temp.size() > 0) {
                for (Node var : temp) {
                    System.out.print(var.val + " ");
                }
                System.out.println("");
                LinkedList<Node> parents = temp;
                temp = new LinkedList<>();
                for (Node parent : parents) {
                    if (parent.left != null) {
                        temp.add(parent.left);
                    }

                    if (parent.right != null) {
                        temp.add(parent.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        LevelBST obj = new LevelBST();

        Node root = obj.new Node(2);
        root.left = obj.new Node(3);
        root.right = obj.new Node(4);

        root.left.left = obj.new Node(5);
        root.right.left = obj.new Node(6);

        root.left.right = obj.new Node(7);
        root.right.right = obj.new Node(8);

        root.left.left.left = obj.new Node(9);
        root.right.left.left = obj.new Node(10);

        root.left.right.left = obj.new Node(11);
        root.right.right.left = obj.new Node(12);

        root.left.left.right = obj.new Node(13);
        root.right.left.right = obj.new Node(14);

        root.left.right.right = obj.new Node(15);
        root.right.right.right = obj.new Node(16);

        System.out.println("printing 1st way");
        obj.Print1(root);
        System.out.println("printing 2nd way");
        obj.Print2(root);
        System.out.println("printing second last nodes");
        obj.Print3(root);
    }

}
