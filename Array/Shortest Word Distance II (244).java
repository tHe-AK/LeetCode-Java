public class WordDistance {
    private Map<String, List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        
        for (int i = 0; i < words.length; i++) {
            String key = words[i];
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Integer>());
            }
            
            map.get(key).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        while (i < list1.size() && j < list2.size()) {
            min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            
            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
