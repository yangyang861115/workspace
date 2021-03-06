package easy;

import java.util.Arrays;

/*
 * 66
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 9999, 879
 * */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] ans = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        ans[0] = 1;
        return ans;
    }
}
