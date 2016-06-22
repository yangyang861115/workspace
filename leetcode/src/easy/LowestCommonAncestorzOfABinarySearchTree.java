package easy;

/*
 * 235
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * “The lowest common ancestor is defined between two nodes v and w 
 * as the lowest node in T that has both v and w as descendants 
 * (where we allow a node to be a descendant of itself).”
 * */
public class LowestCommonAncestorzOfABinarySearchTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if ((root.val - p.val) * (root.val - q.val) <= 0)
            return root;
        else if ((p.val < root.val) && (q.val < root.val))
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
    }
}
