class Solution {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        
        for (String word : words) {
            if (check(S, word)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean check(String S, String word) {
        int i = 0;
        int j = 0;
        
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) != word.charAt(j)) {
                return false;
            }
            
            int x = i++;
            int y = j++;
            
            while (i < S.length() && S.charAt(i) == S.charAt(i - 1)) {
                i++;
            }
            
            while (j < word.length() && word.charAt(j) == word.charAt(j - 1)) {
                j++;
            }
            
            int num1 = i - x;
            int num2 = j - y;
            
            if (num1 < num2 || (num1 < 3 && num1 != num2)) {
                return false;
            }
        }
        
        return i == S.length() && j == word.length();
    }
}
