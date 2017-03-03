public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] rec = new int[256];
        
        for (int i = 0; i < p.length(); i++) {
            rec[p.charAt(i)]++;
        }
    
        int start = 0;
        int end = 0;
        int count = p.length();
        List<Integer> result = new ArrayList<>();
        
        while (end < s.length()) {
            if (rec[s.charAt(end++)]-- > 0) {
                count--;
            }
            
            while (count == 0) {
                if (end - start == p.length()) {
                    result.add(start);
                }
            
                if (rec[s.charAt(start++)]++ >= 0) {
                    count++;
                }
            }
        }
        
        return result;
    }
}
