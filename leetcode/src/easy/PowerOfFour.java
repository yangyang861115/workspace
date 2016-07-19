package easy;
/*
 * 342
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return ((num & (num - 1)) == 0 && num > 0 && (num - 1) % 3 == 0);
    }
    
}
