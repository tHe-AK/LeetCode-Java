public class Solution {
    public boolean detectCapitalUse(String word) {
        int upper = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upper++;
            }
        }
        
        if (upper == 1) {
            return Character.isUpperCase(word.charAt(0));
        } else {
            return upper == 0 || upper == word.length();
        }
    }
}
