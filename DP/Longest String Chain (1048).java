class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int res = 0;
        
        for (String word : words) {
            int max = 0;
            
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                max = Math.max(max, dp.getOrDefault(prev, 0) + 1);
            }
            
            dp.put(word, max);
            res = Math.max(res, max);
        }
        
        return res;
    }
}
