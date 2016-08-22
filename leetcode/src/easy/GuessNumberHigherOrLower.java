package easy;
/*
 * 374
 * Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.
 * */
public class GuessNumberHigherOrLower {
    
}

//public class Solution extends GuessGame{
//    /* The guess API is defined in the parent class GuessGame.
//    @param num, your guess
//    @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
//       int guess(int num); */
//    
//    public int guessNumber(int n) {
//        return myGuess(1, n);
//    }
//    
//    public int  myGuess(int start, int end) {
//        int num = start + (end - start) /2; // pay attention to overflow for two larger integer numbers plus
//        int result = guess(num);
//        if(result == 0) return num;
//        else if(result == -1) return myGuess(start, num - 1);
//        else return myGuess(num + 1, end);
//    }
//}
