package easy;
/*
 * 258
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Could you do it without any loop/recursion in O(1) runtime?
 * 9----> 9, others ----> %9
 * */

public class AddDigits {
    public int addDigits(int num) {
        //return num - 9 * (int) (Math.floor((num - 1) / 9));
        return num == 0 ? 0 : (num % 9 == 0? 9 : (num % 9));
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AddDigits ad = new AddDigits();
        System.out.println(ad.addDigits(18));        
        System.out.println(ad.addDigits(20));
    }

}