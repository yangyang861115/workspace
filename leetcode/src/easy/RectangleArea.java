package easy;
/*
 * 223
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Rectangle Area
 * Assume that the total area is never beyond the maximum possible value of int.
 * */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ans = (C - A)*(D - B) + (G - E)*(H - F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(F, B);
        int top = Math.min(H, D);
        int overlap = 0;
        if(left < right && bottom < top) {
            overlap = (right - left)*(top - bottom);
        }
        
        return ans - overlap;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RectangleArea ra = new RectangleArea();
        System.out.println(ra.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }

}
