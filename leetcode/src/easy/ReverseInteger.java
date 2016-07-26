package easy;
/*
 * 7
 * Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * */
public class ReverseInteger {
    public int reverse(int x) {
       
        long num = Math.abs(x);
        long mynumber = 0;
        while(num > 0){
            mynumber = (10 * mynumber + num % 10);
            num /= 10;
        }
        if(mynumber > Integer.MAX_VALUE || mynumber < Integer.MIN_VALUE) return 0; 
        if(x < 0) return -1 * (int)mynumber;
        return (int)mynumber;
    }
}
