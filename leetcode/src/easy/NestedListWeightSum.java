package easy;

import java.util.List;
/*
 * 339
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 * */


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedListWeightSum {
    
//public int depthSum(List<NestedInteger> nestedList) {
//        
//        return helper(nestedList, 1, 0);
//    }
//    
//    public int helper(List<NestedInteger> nestedList, int depth, int total){
//        if(nestedList == null) return 0;
//        for(int i = 0; i < nestedList.size(); i++) {
//            
//            if(nestedList.get(i).isInteger()) {
//                total += depth * (nestedList.get(i).getInteger());
//            } else {
//                total += helper(nestedList.get(i).getList(), depth+1, 0);
//            }
//        }
//        return total;
//        
//    }
//
}
