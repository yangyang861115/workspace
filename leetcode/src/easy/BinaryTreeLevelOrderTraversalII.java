package easy;

import java.util.*;
/*
 * 107
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 * */
public class BinaryTreeLevelOrderTraversalII {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null)
            return ans;

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        ans.add(0, list);

        while (!queue.isEmpty()) {

            ArrayDeque<TreeNode> queue2 = new ArrayDeque<TreeNode>();
            list = new ArrayList<Integer>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    list.add(node.left.val);
                    queue2.offer(node.left);
                }

                if (node.right != null) {
                    list.add(node.right.val);
                    queue2.offer(node.right);
                }
            }
            // System.out.println(queue2);
            if (list.size() > 0)
                ans.add(0, list);
            queue = queue2;
        }
        return ans;
    }
}
