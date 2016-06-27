package easy;
/*
 * 67
 * Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"
Return "100".
 * */
public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder stb = new StringBuilder();
        while(i >=0 || j >= 0){
            int c1 = (i >= 0 ? Character.getNumericValue(a.charAt(i)) : 0);
            int c2 = (j >= 0 ? Character.getNumericValue(b.charAt(j)) : 0);
            int sum = c1 + c2 + carry;
            
            if(sum == 0 || sum == 1) {
                char ans = sum % 2 == 1 ? '1' : '0'; 
                stb.insert(0, ans);
                carry = 0;
            } else if(sum == 2 || sum == 3){
                char ans = sum % 2 == 1 ? '1' : '0'; 
                stb.insert(0, ans);
                carry = 1;
            } 
            i--;
            j--;
            System.out.println("c1 = " + c1 + " c2 = " + c2);
        }
        if(carry == 1) stb.insert(0, '1');
        
        return stb.toString();
    }
    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        String ans = ab.addBinary("11", "1");
        System.out.println(ans);
    }

}
