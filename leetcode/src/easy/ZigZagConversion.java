package easy;
/*
 * 6
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        int n = s.length();
        for(int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        
        for(int i = 0; i < n; ) {
            for(int j = 0; j < numRows && i < n; j++ , i++) {
                sb[j].append(s.charAt(i));
            }
            for(int j = numRows - 2; j > 0 && i < n; j--, i++) {
                sb[j].append(s.charAt(i));
            }
        }
        
        for(int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
    
        return sb[0].toString();
     }
}
