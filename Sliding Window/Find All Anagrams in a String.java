public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || p.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        int[] rec = new int[26];
        
        for (int i = 0; i < p.length(); i++) {
            rec[p.charAt(i) - 'a']++;
        }
    
        int start = 0;
        int end = 0;
        int count = p.length();
        List<Integer> result = new ArrayList<Integer>();
        
        while (end < s.length()) {
            if (rec[s.charAt(end++) - 'a']-- > 0) {
                count--;
            }
            
            if (count == 0) {
                result.add(start);
            }
            
            if (end - start == p.length() && rec[s.charAt(start++) - 'a']++ >= 0) {
                count++;
            }
        }
        
        return result;
    }
}
