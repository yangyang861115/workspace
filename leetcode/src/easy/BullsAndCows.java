package easy;

import java.util.*;

/*
 * 299
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 * */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        char[] secretarray = secret.toCharArray();
        char[] guessarray = guess.toCharArray();
        String answer;
        int n1 = 0, n2 = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < secretarray.length; i++) {
            if(secretarray[i] == guessarray[i]) n1++;
            if(map.containsKey(secretarray[i])) {
                map.put(secretarray[i], map.get(secretarray[i]) + 1);
            } else {
                map.put(secretarray[i], 1);
            }
        }
        for(int i = 0;  i < secretarray.length; i++) {
            if(map.containsKey(guessarray[i]) && map.get(guessarray[i]) > 0) {
                map.put(guessarray[i], map.get(guessarray[i]) - 1);
                n2++;
            }
        }
        
        answer = n1 + "A" + (n2 - n1) + "B";
        return answer;
    }
    
    public String getHint2(String secret, String guess) {
        String answer;
        int n1 = 0, n2 = 0;
        int[] nums = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if(s == g) n1++;
            else {
                if(nums[s] < 0) n2++;
                if(nums[g] > 0) n2++;
                nums[s]++;
                nums[g]--;
            }
            
        }
        
        answer = n1 + "A" + n2 + "B";
        return answer;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BullsAndCows bc = new BullsAndCows();
        System.out.println(bc.getHint2("1807", "7810"));
        System.out.println(bc.getHint2("1123", "0111"));

    }

}