package array4;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Problem</a>
 **/
public class LongestSubstringWithoutRepetition {
    public int lengthOfLongestSubstring(String s) {
        var map = new HashMap<Character, Integer>();
        int start = 0, end = 0;
        int ans = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (map.containsKey(c)) {
                ans = Math.max(ans, end - start);
                start = map.get(c) + 1;
                map.remove(c);
            }
            map.put(c, i);
            end++;
        }
        return ans;
    }
}
