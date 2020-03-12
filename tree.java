

class Tree {

    public int size;
    public Node root;

    public Tree() {
        root = new Node(null, -1000000000);
        size = 0;

    }

    public Boolean insert(Node parent, int value, int location) {
        parent.children[location] = new Node(parent,value);
        return true;
    }

    public boolean search(Node parent, int data) {
        return false;
    }

    public class Node {

        Node parent;
        Node children[];
        int value;
        int A;
        int B;

        public Node(Node p, int v) {
            parent = p;
            value = v;
            children = new Node[7];
        }
    }
}