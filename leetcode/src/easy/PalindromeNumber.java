package easy;
/*
 * 9
 * Determine whether an integer is a palindrome.
 * Do this without extra space.
 * */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while(rev < x){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev == x || rev / 10 == x;
    }
}
