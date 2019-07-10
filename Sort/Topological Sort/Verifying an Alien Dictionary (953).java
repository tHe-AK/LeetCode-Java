class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] idx = new int[26];
        
        for (int i = 0; i < order.length(); i++) {
            idx[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean isFound = false;
            
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                
                if (ch1 != ch2) {
                    if (idx[ch1 - 'a'] > idx[ch2 - 'a']) {
                        return false;
                    }
                    
                    isFound = true;
                    break;
                }
            }
            
            if (!isFound && word1.length() > word2.length()) {
                return false;
            }
        }
        
        return true;
    }
}
