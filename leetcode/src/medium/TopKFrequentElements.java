package medium;

import java.util.*;

/*
 * 347 Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        
        //can be changed to minimum heap, with size k
        PriorityQueue<Node> heap = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n2.count - n1.count;
            }
        });
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        
        for(int key : map.keySet()) {
            
            heap.add(new Node(key, map.get(key)));
        }
        
        for(int i = 0; i < k; i++) {
            Node node = heap.poll();
            ans.add(node.val);
        }
        return ans;
        
        
    }
    
    class Node {
        int val;
        int count;
        
        Node(int value, int c) {
            val = value;
            count = c;
        }
    }
}
