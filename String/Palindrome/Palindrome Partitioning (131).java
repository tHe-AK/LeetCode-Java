public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int len = s.length();
        boolean[][] rec = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            isPalindrome(s, rec, i, i);
            isPalindrome(s, rec, i, i + 1);
        }
        
        dfs(s, rec, 0, new ArrayList<String>(), result);
        
        return result;
    }
    
    private void isPalindrome(String s, boolean[][] rec, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            rec[low][high] = true;
            low--;
            high++;
        }
    }
    
    private void dfs(String s, boolean[][] rec, int start, List<String> curr, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(curr));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (rec[start][i]) {
                curr.add(s.substring(start, i + 1));
                dfs(s, rec, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
