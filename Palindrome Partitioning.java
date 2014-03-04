public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<ArrayList<String>>();
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
            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                rec[left][right] = true;
                left--;
                right++;
            }
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        helper(0, s, new ArrayList<String>(), rec, result);
        
        return result;
    }
    
    private void helper(int index, String s, ArrayList<String> cur, boolean[][] rec, ArrayList<ArrayList<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(cur));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (rec[index][i] == true) {
                cur.add(s.substring(index, i + 1));
                helper(i + 1, s, cur, rec, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
