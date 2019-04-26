class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String str = null;
        int max = 0;
        
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        
        for (String word : words) {
            if (!set.contains(word)) {
                int val = map.getOrDefault(word, 0) + 1;
                
                if (val > max) {
                    max = val;
                    str = word;
                }
                
                map.put(word, val);
            }
        }
        
        return str;
    }
}
