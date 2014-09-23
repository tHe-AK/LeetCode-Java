public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        if (s == null) {
            return result;
        }
        
        int len = s.length();
        boolean[][] rec = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                rec[left][right] = true;
                left--;
                right++;
            }
            
            left = i - 1;
            right = i;
            
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                rec[left][right] = true;
                left--;
                right++;
            }
        }
        
        helper(s, 0, rec, new ArrayList<String>(), result);
        
        return result;
    }
    
    private void helper(String s, int start, boolean[][] rec, List<String> cur, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(cur));
            return;
        }
        
        for (int i = 0; i < rec[start].length; i++) {
            if (rec[start][i]) {
                cur.add(s.substring(start, i + 1));
                helper(s, i + 1, rec, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
