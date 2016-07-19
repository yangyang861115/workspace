package easy;
/*
 * 125
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Character.isLetterOrDigit(cHead)
 * */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == "" || s.length() == 1) return true;
        
        s = s.toLowerCase();
        int n = s.length();
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(str.contains(s.charAt(i) + "")) {
                sb.append(s.charAt(i));
            }
        }
        
        n = sb.length();
        for(int i = 0, j = n -1; i < j; i++, j--) {
            if(sb.charAt(i) != sb.charAt(j)) return false;
        }
        return true;
    }
    
    public boolean isPalindrome2(String s) {
        if(s == "" || s.length() == 1) return true;
        
        int n = s.length();
        for(int i = 0, j = n -1; i < j; ) {
            char head = s.charAt(i);
            char tail = s.charAt(j);
            if(!Character.isLetterOrDigit(head))  i++;
            else if(!Character.isLetterOrDigit(tail))  j--;
            else {
                if(Character.toLowerCase(head) == Character.toLowerCase(tail)){
                    i++;
                    j--;
                }else{
                    return false;
                }
            } 
        }
        return true;
    }
}
