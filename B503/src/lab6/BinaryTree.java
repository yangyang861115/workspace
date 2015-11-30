package lab6;

public class BinaryTree {
    Node root;
    int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public BinaryTree(Node node) {
        root = node;
        size = 1;
    }

    public boolean search(Node s, int value) {
        if (s == null) {
            return false;
        }
        if (s.value == value) {
            return true;
        } else if (s.value < value) {
            return search(s.right, value);
        } else {
            return search(s.left, value);
        }
    }

    public void insertRecursive(Node s, int value) {
        // recursively insert, insert from the second element in the array
        if (s == null)
            throw new NullPointerException("error!");
        if (s.value < value) {

            if (s.right == null) {
                s.right = new Node(value);
                size++;
            } else {
                insertRecursive(s.right, value);
            }
        } else {
            if (s.left == null) {
                s.left = new Node(value);
                size++;
            } else {
                insertRecursive(s.left, value);
            }
        }
    }

    public void insertNonRecursive(Node s, int value) {
        // insert from root
        Node p = null;
        Node tmp = new Node(value);
        if (s == null) {
            root = tmp;
            size++;
        } else {
            while (s != null) {
                p = s;
                if (s.value <= value) {
                    s = s.right;
                } else {
                    s = s.left;
                }
            }
            if (p.value > value && p.left == null) {
                p.left = tmp;
            } else if(p.value <= value && p.right == null){
                p.right = tmp;
            }
        }
    }

    public void traversal(Node s) {
        if (s != null) {

            traversal(s.left);
            System.out.print(s.value + " ");
            traversal(s.right);
        }
    }
}
