package lab11;

import java.util.Comparator;

public class MST {
    // quick sort
    public int partition(Edge A[], int left, int right) {
        Edge pivot = A[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (A[j].cost <= pivot.cost) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, right);
        return i + 1;
    }

    public void swap(Edge[] a, int i, int j) {
        if (i == j)
            return;
        Edge tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void quickSort(Edge[] edges, int l, int r) {
        if (l < r) {
            int p = partition(edges, l, r);
            quickSort(edges, l, p - 1);
            quickSort(edges, p + 1, r);
        }
    }

    public int findSet(int parent[], int u) {
        while (parent[u] != u) {
            u = parent[u];
        }
        return u;
    }

    public void union(int parent[], int u, int v) {
        parent[findSet(parent, v)] = u;
    }

    public static void main(String[] args) {
        MST mst = new MST();
        Comparator<Edge> cmp = new Comparator<Edge>() {
            public int compare(Edge n1, Edge n2) {
                return n1.cost - n2.cost;
            }
        };
        int n = 9;
        int parent[] = new int[9];
        for (int i = 0; i < 9; i++) {
            parent[i] = i;
        }
        int numEdge = 14;
        Edge[] edges = { new Edge(0, 1, 4), new Edge(0, 5, 8), new Edge(1, 2, 8), new Edge(1, 5, 11), new Edge(2, 6, 2),
                new Edge(2, 3, 7), new Edge(2, 8, 4), new Edge(3, 4, 9), new Edge(3, 8, 14), new Edge(4, 8, 10),
                new Edge(5, 6, 7), new Edge(5, 7, 1), new Edge(6, 7, 6), new Edge(7, 8, 2) };
        mst.quickSort(edges, 0, 13);
        int cost = 0;
        System.out.println("u\t" + "v\t" + "weight");
        for (Edge e : edges) {
            int u = e.u;
            int v = e.v;
            int weight = e.cost;
            if (mst.findSet(parent, u) != mst.findSet(parent, v)) {
                // union u and v
                System.out.println(u + "\t" + v + "\t" + weight);
                mst.union(parent, u, v);
                cost += weight;
            }
        }
        System.out.println("The total cost is " + cost);
        for (int i = 0; i < n; i++) {
            System.out.println("node = " + i + " parent = " + parent[i]);
        }

    }

}

class Edge {
    int u;
    int v;
    int cost;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}
