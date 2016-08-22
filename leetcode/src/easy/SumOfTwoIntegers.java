package easy;
/*
 * 371
 * Sum of Two Integers
 * Calculate the sum of two integers a and b, 
 * but you are not allowed to use the operator + and -.
Example:
Given a = 1 and b = 2, return 3.
 * */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int carry = a & b;
        
        if(carry == 0) return a ^ b;
        
        else {
            a = a ^ b;
            return getSum(a, carry<<1);
        }
    }
}
