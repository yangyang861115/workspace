package lab9;

import java.util.PriorityQueue;

public class Huffman {

    public Node huffman(PriorityQueue<Node> lst) {
        int n = lst.size();
        for (int i = 1; i < n; i++) {
            Node x = lst.poll();
            Node y = lst.poll();

            Node z = new Node(x.freq + y.freq, x, y);
            lst.add(z);
        }
        return lst.poll();
    }

    public void printTree(Node t, int depth, String code) {
        if (t.symbol != 0) {
            System.out.println("depth = "+ depth +" Codeword for " + t.symbol + " is " + code);

        } else {
            
            printTree(t.left, depth + 1, code + '0');
            
            printTree(t.right, depth + 1, code + '1');
        }
    }
    

    public static void main(String[] args) {
        int n = 6;
        Node[] nodelist = { new Node('a', 45, null, null), 
                            new Node('b', 13, null, null), 
                            new Node('c', 12, null, null),
                            new Node('d', 16, null, null), 
                            new Node('e', 9, null, null),
                            new Node('f', 5, null, null) };
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (Node i : nodelist) {
            pq.add(i);
        }

        // print out the Nodes
        // for (int i = 0; i < n; i++) {
        // Node t = (Node) pq.peek();
        // pq.poll();
        // System.out.println(t.symbol + " " + t.freq);
        // }

        Huffman h = new Huffman();

        Node x = h.huffman(pq);

        // System.out.println(x.symbol);

        
        h.printTree(x, 0, "");
        
    }

}
