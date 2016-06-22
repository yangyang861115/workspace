package easy;

/*
 * 13
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * */
public class RomanToInteger {
    public int romanToInt(String s) {
        // rules:位于大数的后面时就作为加数；位于大数的前面就作为减数
        // eg：Ⅲ=3,Ⅳ=4,Ⅵ=6,ⅩⅨ=19,ⅩⅩ=20,ⅩLⅤ=45,MCMⅩⅩC=1980
        int num = 0;
        if (s.length() == 1)
            return value(s.charAt(0));
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            int preval = value(s.charAt(i));
            int curval = value(s.charAt(j));
            if (preval < curval) {
                num += (curval - preval);
                i++;
            } else {
                num += preval;
            }
            if (i == n - 2)
                num += value(s.charAt(i + 1));
        }

        return num;
    }

    public int value(char c) {
        switch (c) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return -1;
        }
    }

    public static void main(String[] args) {
        RomanToInteger ri = new RomanToInteger();
        System.out.println(ri.romanToInt("VVI"));
    }

}
