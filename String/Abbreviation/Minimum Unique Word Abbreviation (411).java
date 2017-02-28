public class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        int[] min = new int[1];
        min[0] = target.length();
        String[] result = new String[1];
        result[0] = target;
        
        dfs(target, dictionary, 0, 0, "", min, result);
        
        return result[0];
    }
    
    private void dfs(String target, String[] dictionary, int start, int count, String curr, int[] min, String[] result) {
        if (count >= min[0]) {
            return;
        }
        
        int len = target.length();
        
        if (start >= len) {
            for (String word : dictionary) {
                if (validWordAbbreviation(word, curr)) {
                    return;
                }
            }
            
            min[0] = count;
            result[0] = curr;
            return;
        }
        
        dfs(target, dictionary, start + 1, count + 1, curr + target.charAt(start), min, result);
        
        for (int end = start + 1; end <= len; end++) {
            if (end < len) {
                dfs(target, dictionary, end + 1, count + 2, curr + (end - start) + target.charAt(end), min, result);
            } else {
                dfs(target, dictionary, end, count + 1, curr + (end - start), min, result);
            }
        }
    }
    
    public boolean validWordAbbreviation(String target, String abbr) {
        int i = 0;
        int j = 0;
        int len1 = target.length();
        int len2 = abbr.length();
        
        while (i < len1 && j < len2) {
            char ch1 = target.charAt(i);
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
