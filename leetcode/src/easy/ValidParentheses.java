package easy;
import java.util.*;
/*
 * 20
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if( c == '(' || c == '{' || c== '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                
                char d = stack.pop();
                if(c == ')' && d != '(') return false;
                if(c == ']' && d != '[') return false;
                if(c == '}' && d != '{') return false;
            } 
        }
        
        return stack.isEmpty();
    }
}
