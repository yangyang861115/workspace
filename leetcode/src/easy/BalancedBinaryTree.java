package easy;

/*
 * 110
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return helper(root) != -1;
    }

    public int helper(TreeNode node) {
        if (node == null)
            return 0;
        int leftheight = helper(node.left);
        if (leftheight == -1)
            return -1;
        int rightheight = helper(node.right);
        if (rightheight == -1)
            return -1;
        if (Math.abs(leftheight - rightheight) > 1)
            return -1;
        return 1 + Math.max(leftheight, rightheight);
    }
}
