package lab5;

class Node {
    double d;
    Node next;
    
    Node (double val) {
        d = val;
        next = null;
    }
    
    Node(double val, Node n){
        d = val;
        next = n; 
    }
}
