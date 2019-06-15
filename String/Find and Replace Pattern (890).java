class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        
        for (String word : words) {
            if (wordPattern(word, pattern)) {
                res.add(word);
            }
        }
        
        return res;
    }
    
    private boolean wordPattern(String word, String pattern) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Integer i = 0; i < word.length(); i++) {
            if (map1.put(word.charAt(i), i) != map2.put(pattern.charAt(i), i)) {
                return false;
            }
        }
        
        return true;
    }
}
