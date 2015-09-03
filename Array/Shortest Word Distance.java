public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || word1 == null || word2 == null) {
            throw new IllegalArgumentException();
        }
        
        int id1 = -1;
        int id2 = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                id1 = i;
            }
            
            if (words[i].equals(word2)) {
                id2 = i;
            }
            
            if (id1 != -1 && id2 != -1) {
                min = Math.min(min, Math.abs(id1 - id2));
            }
        }
        
        return min;
    }
}
