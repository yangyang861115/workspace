package easy;
/*
 * 171
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example: A -> 1   B -> 2  AB -> 28 
 * */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] array = s.toCharArray();
        int answer = 0;
        int base = 1;
        for(int i = array.length - 1; i >= 0; i--){
            answer += (array[i] - 'A' + 1) * base;
            base *= 26;
        }
        return answer;
    }
   
}
