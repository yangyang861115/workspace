package easy;
/*
 * 8
 * String to Integer (atoi)
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.
 * */
public class StringToInteger {
    public int myAtoi(String str) {
        int n = str.length();
        int i = 0;
        int sign = 1;
        long ans = 0;
        while(i < n) {
            char c = str.charAt(i);
            if(c == ' ') i++;
            else if(c == '-') {
                sign = -1;
                i++;
                break;
            }else if(c == '+') {
                i++;
                break;
            }else {
                break;
            }
        }
        while(i < n) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                ans = 10 * ans + c - '0';
                i++;
                if(ans * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(ans * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }else {
                break;
            }
        }
        return (int)(ans * sign);
     }
}
