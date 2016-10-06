public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) {
            throw new IllegalArgumentException();
        }
        
        int i = 0;
        int j = 0;
        int len1 = word.length();
        int len2 = abbr.length();
        
        while (i < len1 && j < len2) {
            char c1 = word.charAt(i);
            char c2 = abbr.charAt(j);
            
            if (Character.isDigit(abbr.charAt(j)) && c2 != '0') {
                int start = j++;
            
                while (j < len2 && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                
                int count = Integer.parseInt(abbr.substring(start, j));
                i += count;
            } else if (c1 == c2) {
                i++;
                j++;
            } else {
                return false;
            }

        }
        
        return i == len1 && j == len2;
    }
}
