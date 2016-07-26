package easy;

/*
 * 246
 * Strobogrammatic Number
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            char a = num.charAt(i);
            char b = num.charAt(j);

            if (!checkPair(a, b))
                return false;
        }
        return true;
    }

    public boolean checkPair(char a, char b) {
        if (a > b) {
            char tmp = a;
            a = b;
            b = tmp;
        }
        if ((a == b && (a == '0' || a == '1' || a == '8')) || (a == '6' && b == '9'))
            return true;
        return false;
    }
}
