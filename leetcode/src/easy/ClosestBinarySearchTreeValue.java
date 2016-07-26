package easy;
/*
 * 270
 * Closest Binary Search Tree Value
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target <= a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a: b;   
    }
}
