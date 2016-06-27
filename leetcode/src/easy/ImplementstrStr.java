package easy;
/*
 * 28
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * 
 * */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0; ; i++) {
            for(int j = 0; ; j++){
                if(j == m) return i;
                if(i + j == n) return -1;
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }         
        }
    }
    
    public static void main(String[] args) {
        ImplementstrStr str = new ImplementstrStr();
        System.out.println(str.strStr("abc", "c"));
        
    }

}
