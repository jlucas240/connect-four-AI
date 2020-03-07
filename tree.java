import java.util.ArrayList;

class Tree {

    public int size;
    public Node root;

    public Tree() {
        root = new Node(null, -1000000000);
        size = 0;

    }

    public Boolean insert(Node parent, Node child) {
        parent.children.add(child);
        return true;
    }

    public boolean search(Node parent, int data) {
        return false;
    }

    public class Node {

        Node parent;
        ArrayList<Node> children;
        int value;
        int A;
        int B;

        public Node(Node p, int v) {
            parent = p;
            value = v;
            children = new ArrayList<Node>();
        }
    }
}