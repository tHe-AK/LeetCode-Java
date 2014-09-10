public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        if (s == null) {
            return result;
        }
        
        List<List<Integer>> rec = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < s.length(); i++) {
            rec.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                rec.get(left).add(right);
                left--;
                right++;
            }
            
            left = i - 1;
            right = i;
            
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                rec.get(left).add(right);
                left--;
                right++;
            }
        }
        
        helper(s, 0, rec, new ArrayList<String>(), result);
        
        return result;
    }
    
    private void helper(String s, int start, List<List<Integer>> rec, List<String> cur, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(cur));
            return;
        }
        
        for (int i = 0; i < rec.get(start).size(); i++) {
            int end = rec.get(start).get(i);
            cur.add(s.substring(start, end + 1));
            helper(s, end + 1, rec, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
