public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        
        for (String word : d) {
            int i = 0;
            int j = 0;
            
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                
                i++;
            }
            
            if (j == word.length() && word.length() >= result.length()) {
                if (word.length() > result.length() || word.compareTo(result) < 0) {
                    result = word;
                }
            }
        }
        
        return result;
    }
}
