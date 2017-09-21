class Solution {
    public int characterReplacement(String s, int k) {
        int[] rec = new int[26];
        int start = 0;
        int end = 0;
        int cnt = 0;
        int res = 0;
        
        while (end < s.length()) {
            cnt = Math.max(cnt, ++rec[s.charAt(end++) - 'A']);

            while (end - start - cnt > k) {
                rec[s.charAt(start++) - 'A']--;
                cnt = 0;
                
                for (int i = 0; i < rec.length; i++) {
                    cnt = Math.max(cnt, rec[i]);
                }
            }
            
            res = Math.max(res, end - start);
        }
        
        return res;
    }
}
