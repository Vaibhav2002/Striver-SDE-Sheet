package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning/">Problem</a>
 **/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        fill(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void fill(String s, int i, List<String> cur, List<List<String>> ans) {
        if (i == s.length()) {
            ans.add(cur);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                cur.add(s.substring(i, j + 1));
                fill(s, j + 1, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}