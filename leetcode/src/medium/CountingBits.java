package medium;

import java.util.Arrays;

/*
 * 338
 * Counting Bits
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * */
public class CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for(int i = 1; i <= num; i++) {
            // 10, 100
            if((i & (i - 1)) == 0) ans[i] = 1;
            else {
                //110, 1010
                if((i & 1) == 0) {
                    int number = i;
                    int count = 0;
                    while((number & 1) == 0){    
                        number = (number >> 1);
                        count++;
                    }
                    ans[i] = ans[i - 1] - (count - 1);
                }
                //111, 1011
                else {
                    ans[i] = ans[i - 1] + 1;
                }
            }
        }
        return ans;
    }
    
    //smart method
    public int[] countBits2(int num) {
        int[] answer = new int[num+1];
        if(num >= 0) answer[0] = 0;
        for(int i = 1;i<=num;i++){
            answer[i] = answer[i/2] + i%2;   
        }
        return answer;
    }

}
