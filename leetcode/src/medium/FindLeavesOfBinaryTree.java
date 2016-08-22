package medium;

import java.util.*;

/*
 * 366
 * Find Leaves of Binary Tree 
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
 * */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        helper(root, ans);
        return ans;
    }
    
    //depth of the node
    public int helper(TreeNode node, List<List<Integer>> ans) {
        if(node == null) return 0;
        int left = helper(node.left, ans);
        int right = helper(node.right, ans);
        int level = Math.max(left, right);
        if(ans.size() <= level) {
            List<Integer> leaves = new ArrayList<Integer>();
            leaves.add(node.val);
            ans.add(leaves);
        }else {
            ans.get(level).add(node.val);
        }
        return 1 + level;
    }
}
