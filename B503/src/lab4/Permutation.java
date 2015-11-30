package lab4;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public void permutation3 (List<Character> s, int start, List<String> result) {
        if (start == s.size()) {
            result.add(arrayToString(s));
            return;
        }
        for (int i = start; i < s.size(); i++) {
            swap(s, start, i);
            permutation3(s, start + 1, result);
            swap(s, start, i);
        }
    }
    void swap(List<Character> s, int i, int j) {
        Character tmp = s.get(i);
        s.set(i, s.get(j));
        s.set(j, tmp);
    }
    String arrayToString(List<Character> s) {
        String result = "";
        for (char c : s) {
            result += c;
        }
        return result;
    }
    
    public void permutation2(final String s, final List<String> result) {
        if (s.length() == 0) {
            result.add("");
            return;
        }

        List<String> list = new ArrayList<String>();
        permutation2(s.substring(1), list);
        for (String sub : list) {
            for (int i = 0; i <= sub.length(); i++) {
                result.add(sub.substring(0, i) + s.charAt(0) + sub.substring(i));
            }
        }

    }

    public List<String> permutation(String s) {

        List<String> list = new ArrayList<String>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        for (String sub : permutation(s.substring(1))) {
            // list.add(sub + s.charAt(0));
            // list.add(s.charAt(0) + sub);

            for (int i = 0; i <= sub.length(); i++) {
                list.add(sub.substring(0, i) + s.charAt(0) + sub.substring(i));
            }

        }
        return list;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Permutation p = new Permutation();
        System.out.println(p.permutation("abc"));
        
        List<String> result = new ArrayList<String>();
        p.permutation2("abc", result);
        System.out.println(result);
        
        List<Character> s = new ArrayList<Character>();               
        s.add('a');
        s.add('b');
        s.add('c');
        List<String> result2 = new ArrayList<String>();
        p.permutation3 (s, 0, result2);
        System.out.println(result2);
    }

}
