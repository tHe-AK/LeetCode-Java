public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        List<String> result = new ArrayList<String>();
        
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        helper(s, 4, 0, "", result);
        
        return result;
    }
    
    private void helper(String s, int count, int start, String cur, List<String> result) {
        if (s.length() - start < count || s.length() - start > count * 3) {
            return;
        }
        
        if (count == 0) {
            result.add(cur.substring(0, cur.length() - 1));
        }
        
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            int num = Integer.parseInt(str);
            
            if (num < 0 || num > 255) {
                break;
            }

            helper(s, count - 1, i + 1, cur + str + ".", result);
            
            if (num == 0) {
                break;
            }
        }
    }
}