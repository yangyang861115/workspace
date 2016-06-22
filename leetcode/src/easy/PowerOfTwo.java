package easy;
/*
 * 231
 * Given an integer, write a function to determine if it is a power of two.
 * Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge
 * */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n-1)) == 0;
        
        //return Math.log10(n) / Math.log10(2) % 1 == 0;
        
        //return n > 0 && (n == 1 || (n % 2 == 0 && isPowerOfTwo(n/2)));
    }
}
