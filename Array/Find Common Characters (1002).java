class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int N = 26;
        int[] count = new int[N]; 
        Arrays.fill(count, Integer.MAX_VALUE);
        
        for (String str : A) {
            int[] temp = new int[N];
            
            for (int i = 0; i < str.length(); i++) {
                temp[str.charAt(i) - 'a']++;
            }
            
            for (int i = 0; i < N; i++) {
                count[i] = Math.min(count[i], temp[i]);
            }
        }
        
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                ans.add("" + c);
            }
        }
        
        return ans;
    }
}
