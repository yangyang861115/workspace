package easy;

import java.util.*;

/*
 * 202
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 1*1 + 9*9 = 82
 * 8*8 + 2*2 = 68
 * 6*6 + 8*8 = 100
 * 1 + 0 + 0 = 1
 * */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n != 1){
            int newNum = 0;
            while(n > 0) {
                int digit = n % 10;
                newNum += digit * digit;
                n /= 10;
            }
           
            System.out.println(newNum);
            if(set.contains(newNum)) return false;
            else {
                n = newNum;
                set.add(newNum);
            }
        }
        return true;
    }
}
