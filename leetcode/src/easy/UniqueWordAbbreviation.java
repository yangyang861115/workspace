package easy;

import java.util.*;

/*
 * 288
 * Unique Word Abbreviation
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
 * */
public class UniqueWordAbbreviation {
private Map<String, Set<String>> mydict;
    

    public UniqueWordAbbreviation(String[] dictionary) {
        mydict = new HashMap<String, Set<String>>();
        for(String s : dictionary) {
                String abbr = s.length() > 2 ? abbreviation(s) : s;
                if(mydict.containsKey(abbr)) {
                    mydict.get(abbr).add(s);
                }else {
                    Set<String> set = new HashSet<String>();
                    set.add(s);
                    mydict.put(abbr, set);
                }
        
        }
    }

    public boolean isUnique(String word) {
        String abbr = abbreviation(word);
        if(!mydict.containsKey(abbr)) return true;
        else if(mydict.get(abbr).size() == 1 && mydict.get(abbr).contains(word)) return true;
        return false;
    }
    
    private String abbreviation(String word) {
        int n = word.length();
        if(n <= 2) return word;
        return Character.toString(word.charAt(0)) + (n - 2) + Character.toString(word.charAt(n - 1));
    }
}
