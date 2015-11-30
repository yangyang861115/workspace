package lab6;

public class Node {
    int value;
    Node parent;
    Node left;
    Node right;
    public Node(int v){
        value = v;
        parent = null;
        left = null;
        right = null;
    }
    
    public Node(int v, Node p, Node l, Node r){
        value = v;
        parent = p;
        left = l;
        right = r;
    }
    
    public Node(int v, Node p){
        value = v;
        parent = p;
        left = null;
        right = null;
    }
}
