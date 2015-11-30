package lab7;

public class LCS {

    public int lcs(String s1, String s2, int p, int q, int cache[][], int direction[][]) {
        if (p == -1 || q == -1) {
            return 0;
        } else {
            if (cache[p][q] != -1) {
                return cache[p][q];
            } else {
                if (s1.charAt(p) == s2.charAt(q)) {
                    cache[p][q] = lcs(s1, s2, p - 1, q - 1, cache, direction) + 1;
                    direction[p][q] = 0;
                } else {
                    int v1 = lcs(s1, s2, p - 1, q, cache, direction);
                    int v2 = lcs(s1, s2, p, q - 1, cache, direction);
                    if (v1 >= v2) {
                        cache[p][q] = v1;
                        direction[p][q] = 1;
                    }else{
                        cache[p][q] = v2;
                        direction[p][q] = 2;
                    }
                     
                }
                return cache[p][q];
            }
        }

    }
    public void printPath(int direction[][], int p, int q, String s1, String s2) {   
        if (p == -1 || q == -1) return;
        if (direction[p][q] == 0) {    
        
            printPath(direction, p-1, q-1, s1, s2);
            System.out.print(s1.charAt(p));
        }
        else if (direction[p][q] == 1) {
            printPath(direction, p-1, q, s1, s2);
        }
        else if (direction[p][q] == 2){
            printPath(direction, p, q-1, s1, s2);
        }
    }

    public static void main(String[] args) {
        String s1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String s2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        int p = s1.length() - 1;
        int q = s2.length() - 1;
        int cache[][] = new int[p + 1][q + 1];
        int direction[][] = new int[p + 1][q + 1];
        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= q; j++) {
                cache[i][j] = -1;
                direction[i][j] = -1;
            }
        }
        LCS test = new LCS();
        System.out.println(test.lcs(s1, s2, p, q, cache, direction));
        test.printPath(direction, p, q, s1, s2);
    }

}
