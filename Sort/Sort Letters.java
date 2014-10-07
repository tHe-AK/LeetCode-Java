public class Solution {
    public void sortLetters(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException();
        }
        
        int cur = 0;
        
        for (int i = 0; i < chars.length; i++) {
            if ('a' <= chars[i] && chars[i] <= 'z') {
                char temp = chars[i];
                chars[i] = chars[cur];
                chars[cur] = temp;
                cur++;
            }
        }
    }
}