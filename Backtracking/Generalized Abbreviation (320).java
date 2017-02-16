public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        
        dfs(word, 0, "", result);
        
        return result;
    }
    
    private void dfs(String word, int start, String curr, List<String> result) {
        int len = word.length();
        
        if (start >= len) {
            result.add(curr);
            return;
        }
        
        dfs(word, start + 1, curr + word.charAt(start), result);
        
        for (int end = start + 1; end <= len; end++) {
            dfs(word, end + 1, curr + (end - start) + (end < len ? word.charAt(end) : ""), result);
        }
    }
}

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        int len = word.length();
        
        for (int i = 0; i <= (1 << len) - 1; i++) {
            String str = "";
            int num = i;
            int count = 0;
            
            for (int j = 0; j < len; j++) {
                if ((num & 1) == 1) {
                    str += count > 0 ? count : "";
                    count = 0;
                    str += word.charAt(j);
                } else {
                    count++;
                }
                
                num >>= 1;
            }
            
            str += count > 0 ? count : "";
            result.add(str);
        }
        
        return result;
    }
}
