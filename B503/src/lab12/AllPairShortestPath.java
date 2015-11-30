package lab12;

public class AllPairShortestPath {
    public int[][] Floyd_Warshall(int n, Edge[] edges) {
        int[][] D = new int[n][n];
        int[][] intermediate = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                intermediate[i][j] = -1;
                if (i == j) {
                    D[i][j] = 0;
                } else {
                    D[i][j] = 9999;
                }
            }
        }
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int weight = edge.cost;
            D[u][v] = weight;
            intermediate[u][v] = v;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][j] > D[i][k] + D[k][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                        intermediate[i][j] = k;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(i + "====>" + j + " ");
                printPath(i, j, intermediate);
                System.out.println();
            }
            System.out.println();
        }
        return D;

    }

    public void printPath(int u, int v, int intermediate[][]) {
        if (intermediate[u][v] == -1) {
            return;
        }
        if (intermediate[u][v] == v) {
            System.out.print(v + "\t");
            return;
        }
        printPath(u, intermediate[u][v], intermediate);
        printPath(intermediate[u][v], v, intermediate);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 9;
        int e = 14;
        Edge[] edges = { new Edge(0, 1, 4), new Edge(0, 5, 8), new Edge(1, 2, 8), new Edge(1, 5, 11), new Edge(2, 6, 2),
                new Edge(2, 3, 7), new Edge(2, 8, 4), new Edge(3, 4, 9), new Edge(3, 8, 14), new Edge(4, 8, 10),
                new Edge(5, 6, 7), new Edge(5, 7, 1), new Edge(6, 7, 6), new Edge(7, 8, 2) };
        AllPairShortestPath ap = new AllPairShortestPath();
        int D[][] = ap.Floyd_Warshall(n, edges);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(D[i][j] + "\t");
            }
            System.out.println();
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
