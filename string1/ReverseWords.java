package string1;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] word = s.split(" ");
        reverse(word);
        StringBuilder sb = new StringBuilder();
        for (String w : word) {
            w = w.trim();
            if (w.isEmpty()) continue;
            sb.append(w);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private void reverse(String[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            String temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
