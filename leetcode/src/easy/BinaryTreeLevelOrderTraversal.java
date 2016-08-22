package easy;

import java.util.*;

import easy.BinaryTreeLevelOrderTraversalII.TreeNode;

/*
 * 102
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]   
 * */
public class BinaryTreeLevelOrderTraversal {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        

        if (root == null)
            return ans;

        ArrayDeque<TreeNode> queue1 = new ArrayDeque<TreeNode>();
        queue1.offer(root);
        level.add(root.val);
        ans.add(level);

        while (!queue1.isEmpty()) {
            level = new ArrayList<Integer>();
            ArrayDeque<TreeNode> queue2 = new ArrayDeque<TreeNode>();

            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();

                if (node.left != null) {
                    queue2.offer(node.left);
                    level.add(node.left.val);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                    level.add(node.right.val);
                }
            }
            queue1 = queue2;
            if (level.size() > 0) ans.add(level);
        }
        return ans;
    }
}
