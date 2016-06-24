package easy;

import java.util.*;

/*
 * 112
 * Given a binary tree and a sum, determine if the tree has 
 * a root-to-leaf path such that adding up all the values along 
 * the path equals the given sum.
    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
   return true, as there exist a root-to-leaf path
    5->4->11->2 which sum is 22.
 * */
public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    //recursive
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
    //non-recursive
    public boolean hasPathSum2(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();
        stack.push(root);
        sums.push(sum);
        
        while(!stack.empty() && root != null){
            TreeNode node = stack.pop();
            int value = sums.pop();
            
            if(node.left == null && node.right == null && node.val ==value)
                return true;
            
            if(node.left != null) {
                stack.push(node.left);
                sums.push(value - node.val);
            }
            
            if(node.right != null) {
                stack.push(node.right);
                sums.push(value - node.val);
            }
        }
        
        return false;
    }
}
