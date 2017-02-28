public class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        int len = target.length();
        List<Integer> dict = new ArrayList<>();
        
        for (String word : dictionary) {
            if (word.length() == len) {
                dict.add(strToNum(target, word));
            }
        }
        
        int[] min = new int[1];
        min[0] = len;
        int[] result = new int[1];
        result[0] = (1 << len) - 1;
        
        dfs(len, dict, 0, 0, 0, min, result);
        
        return numToStr(target, result[0]);
    }
    
    private void dfs(int len, List<Integer> dict, int start, int curr, int count, int[] min, int[] result) {
        if (count >= min[0]) {
            return;
        }
        
        if (start >= len) {
            for (int word : dict) {
                if ((curr & word) == curr) {
                    return;
                }
            }
            
            min[0] = count;
            result[0] = curr;
            return;
        }
        
        dfs(len, dict, start + 1, (curr << 1) + 1, count + 1, min, result);
        
        for (int end = start + 1; end <= len; end++) {
            if (end < len) {
                dfs(len, dict, end + 1, (curr << (end - start + 1)) + 1, count + 2, min, result);
            } else {
                dfs(len, dict, end, curr << (end - start), count + 1, min, result);
            }
        }
    }
    
    public int strToNum(String target, String word) {
        int num = 0;
        
        for (int i = 0; i < target.length(); i++) {
            num <<= 1;
            
            if (target.charAt(i) == word.charAt(i)) {
                num += 1;
            }
        }
        
        return num;
    }
    
    public String numToStr(String target, int num) {
        String str = "";
        int count = 0;
        
        for (int i = target.length() - 1; i >= 0; i--) {
            if ((num & 1) == 1) {
                if (count > 0) {
                    str = count + str;
                }
                
                count = 0;
                str = target.charAt(i) + str;
            } else {
                count++;
            }
            
            num >>>= 1;
        }
        
        if (count > 0) {
            str = count + str;
        }
        
        return str;
    }
}

public class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        int[] min = new int[1];
        min[0] = target.length();
        String[] result = new String[1];
        result[0] = target;
        
        dfs(target, dictionary, 0, "", 0, min, result);
        
        return result[0];
    }
    
    private void dfs(String target, String[] dictionary, int start, String curr, int count, int[] min, String[] result) {
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
        
        dfs(target, dictionary, start + 1, curr + target.charAt(start), count + 1, min, result);
        
        for (int end = start + 1; end <= len; end++) {
            if (end < len) {
                dfs(target, dictionary, end + 1, curr + (end - start) + target.charAt(end), count + 2, min, result);
            } else {
                dfs(target, dictionary, end, curr + (end - start), count + 1, min, result);
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
