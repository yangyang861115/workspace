package easy;

/*
 * 38
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 * */
public class CountAndSay {
    public String countAndSay(int n) {
        String ans[] = new String[n];
        ans[0] = "1";

        for (int i = 1; i < n; i++) {
            String pre = ans[i - 1];
            String s = "";
            char cur = pre.charAt(0);
            
            int count = 1;
            for (int j = 1; j < pre.length(); j++) {
                if (pre.charAt(j) == cur)
                    count++;
                else {
                    s += count +"" + cur;
                    cur = pre.charAt(j);
                    count = 1;
                }
            }
 
            s += count + "" + cur;
            ans[i] = s;
        }

        return ans[n - 1];
    }

    
    public String countAndSay2(int n) {
        String pre = "1";
        if(n == 1) return pre;
        
        for(int i = 2 ; i <= n; i++) {
            System.out.println(pre);
            String next = "";
            int len = pre.length();
            int count = 1;
            char c = pre.charAt(0);
            for(int j = 1; j < len; j++) {
                if(pre.charAt(j) == c) count++;
                else {
                    next += count + ""+ c;
                    c = pre.charAt(j);
                    count = 1;
                }
            }
           
            next += count + "" + c;
            pre = next;
        }
        return pre;
    }
}
