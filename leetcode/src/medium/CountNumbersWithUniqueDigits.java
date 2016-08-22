package medium;
/*
 * 357  Count Numbers with Unique Digits
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, 
excluding [11,22,33,44,55,66,77,88,99])
 * 
 * */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n > 10) n = 10;
        int[] ans = new int[n];
        ans[0] = 10;
        for(int i = 1; i < n; i++) {
            int first = 9;
            int c = 9;
            for(int j = 1; j <= i; j++) {
                first *= c;
                c--;
            }
            ans[i] = first;
        }
        
        
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += ans[i];
        }
        return total;
    }
    
    public int countNumbersWithUniqueDigits2(int n) {
        if(n == 0) return 1;
        if(n > 10) n = 10;
        
        int c = 9;
        int total = 10;
        
        for(int i = 1; i < n; i++) {
            c = c * (10 - i);
            total += c;
        }
        
        return total;
    }
}
