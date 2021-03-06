package easy;

import java.util.ArrayDeque;

/*
 * 101
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 Bonus points if you could solve it both recursively and iteratively.
 * */

public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return mirror(root.left, root.right);
    }

    public boolean mirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val == node2.val) {
            return mirror(node1.left, node2.right) && mirror(node1.right, node2.left);
        }
        return false;
    }

    // iteratively
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;

        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if (root.left != null) {
            if (root.right == null)
                return false;
            stack.push(root.left);
            stack.push(root.right);
        } else if (root.right != null) {
            return false;
        }
        TreeNode left, right;

        while (!stack.isEmpty()) {
            if (stack.size() % 2 != 0)
                return false;
            left = stack.pop();
            right = stack.pop();

            if (left.val != right.val)
                return false;

            if (left.left != null) {
                if (right.right == null)
                    return false;
                stack.push(left.left);
                stack.push(right.right);
            } else if (right.right != null) {
                return false;
            }

            if (left.right != null) {
                if (right.left == null)
                    return false;
                stack.push(left.right);
                stack.push(right.left);
            } else if (right.left != null) {
                return false;
            }
        }

        return true;
    }

}
