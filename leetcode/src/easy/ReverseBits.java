package easy;
/*
 * 190
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * */
public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        int count = 0;
        while(count != 32){
            System.out.println("ans= " + ans + " n = " + n);
            ans = (ans<<1) + (n&1);
            n = (n>>>1);
            count++;
        }
        return ans;
    }
}
