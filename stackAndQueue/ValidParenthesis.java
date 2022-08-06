package stackAndQueue;

import java.util.*;
import java.util.Stack;

/**
* <a href="https://leetcode.com/problems/valid-parentheses/">Problem</a>
**/
public class ValidParenthesis {

    private HashSet<Character> opening;
    private HashMap<Character, Character> bracketMap;

    public ValidParenthesis() {
        opening = new HashSet<>(Set.of('(', '{','['));
        bracketMap = new HashMap<>(Map.of('(',')','{','}','[',']'));
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c:ch){
            if(opening.contains(c)) st.push(c);
            else{
                if(st.isEmpty()) return false;
                if(bracketMap.get(st.pop()) != c) return false;
            }
        }
        return st.isEmpty();
    }
}
