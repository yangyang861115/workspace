package easy;
import java.util.*;

import easy.BinaryTreeLevelOrderTraversalII.TreeNode;
/*
 * 257
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 * */
public class BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if(root != null) helper(root, "", ans);
        return ans;
    }
    
    public void helper(TreeNode node, String path, List<String> ans){
        if(node.left == null && node.right == null) {
            ans.add(path + node.val);
        }
        if(node.left != null) {
            helper(node.left, path + node.val +"->", ans);
        }
        if(node.right != null) {
            helper(node.right, path + node.val +"->", ans);
        }
    }
}
