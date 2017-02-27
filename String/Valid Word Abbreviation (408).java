public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        int len1 = word.length();
        int len2 = abbr.length();
        
        while (i < len1 && j < len2) {
            char ch1 = word.charAt(i);
            char ch2 = abbr.charAt(j);
            
            if (Character.isDigit(abbr.charAt(j)) && ch2 != '0') {
                int start = j++;
            
                while (j < len2 && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                
                i += Integer.parseInt(abbr.substring(start, j));
            } else if (ch1 == ch2) {
                i++;
                j++;
            } else {
                return false;
            }

        }
        
        return i == len1 && j == len2;
    }
}
