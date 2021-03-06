package easy;

import java.util.ArrayDeque;

import easy.MaximumDepthofBinaryTree.TreeNode;

/*
 * 226
 * Invert a binary tree.
 * */
public class InvertBinaryTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return root;
            TreeNode tmp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = tmp;
            return root;
        }
    }
    
    public class Solution2 {
        //non recursive
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return root;
            ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            return root;
        }
    }
}
