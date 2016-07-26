package easy;
/*
 *168
 *Excel Sheet Column Title 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

 * */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String ans = "";
        while(n > 0) {
            ans =  findTitle((n - 1) % 26) + ans;
            n = (n - 1) /26;
        }
        return ans;
    }
    
    public String findTitle(int number) {
        return Character.toString((char)(number + 65));
    } 
}
