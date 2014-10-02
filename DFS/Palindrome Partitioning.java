public class Solution {
    public List<List<String>> partition(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        int len = s.length();
        boolean[][] rec = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            int low = i;
            int high = i;

            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                rec[low][high] = true;
                low--;
                high++;
            }
            
            low = i - 1;
            high = i;

            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                rec[low][high] = true;
                low--;
                high++;
            }
        }
        
        helper(s, rec, 0, new ArrayList<String>(), result);
        
        return result;
    }
    
    private void helper(String s, boolean[][] rec, int start, List<String> cur, List<List<String>> result) {
        if (s.length() == start) {
            result.add(new ArrayList<String>(cur));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (rec[start][i]) {
                cur.add(s.substring(start, i + 1));
                helper(s, rec, i + 1, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
}