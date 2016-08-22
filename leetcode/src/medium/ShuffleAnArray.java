package medium;

import java.util.Arrays;

/*
 * Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 * 
 * */
public class ShuffleAnArray {
    private int[] originalNums;

    public ShuffleAnArray(int[] nums) {
        int n = nums.length;
        originalNums = Arrays.copyOf(nums, n);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(originalNums, originalNums.length);
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = originalNums.length;
        int[] result = Arrays.copyOf(originalNums, n);
        for(int i = n - 1; i >= 0; i--) {
            int rand = (int) (Math.random()*n);
            //swap i and rand
            int tmp = result[i];
            result[i] = result[rand];
            result[rand] = tmp;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * ShuffleAnArray obj = new ShuffleAnArray(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

