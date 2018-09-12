class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList();
        int[] idx = new int[26];
        
        for (int i = 0; i < S.length(); i++) {
            idx[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, idx[S.charAt(i) - 'a']);
            
            if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return ans;
    }
}
