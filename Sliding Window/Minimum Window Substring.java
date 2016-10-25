public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }
        
        int[] rec = new int[256];
        
        for (char c : t.toCharArray()) {
            rec[c]++;
        }
        
        int start = 0;
        int end = 0;
        int count = t.length();
        int min = Integer.MAX_VALUE;
        String result = "";
        
        while (end < s.length()) {
            if (rec[s.charAt(end++)]-- > 0) {
                count--;
            }

            while (count == 0) {
                if (end - start < min) {
                    min = end - start;
                    result = s.substring(start, end);
                }
                
                if (rec[s.charAt(start++)]++ >= 0) {
                    count++;
                }
            }
        }
        
        return result;
    }
}
