package easy;
/*
 * 7
 * Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
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
