package lab9;

public class Node implements Comparable{

    char symbol;
    int freq;
    Node left;
    Node right;

    public Node(char symbol, int freq) {
        this.symbol = symbol;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    public Node(char symbol, int freq, Node left, Node right) {
        this.symbol = symbol;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
    
    public Node(int freq, Node left, Node right) {
        this.symbol = 0;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Object o) {
        return this.freq - ((Node)o).freq;
    }


}
