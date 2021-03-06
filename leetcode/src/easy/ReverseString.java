package easy;
/*
 * 344
 * Write a function that takes a string as input and returns the string reversed.
 *Example:
 *Given s = "hello", return "olleh".
*/
public class ReverseString {
    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        for(int i = 0, j = charArray.length -1; i < j; i++, j--) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
        }
        return new String(charArray);
    }
}
