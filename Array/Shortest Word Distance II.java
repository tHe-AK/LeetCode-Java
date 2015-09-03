public class WordDistance {
    private Map<String, List<Integer>> rec;
    
    public WordDistance(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException();
        }
        
        rec = new HashMap<String, List<Integer>>();
        
        for (int i = 0; i < words.length; i++) {
            if (!rec.containsKey(words[i])) {
                rec.put(words[i], new ArrayList<Integer>());
            }
            
            rec.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException();
        }
        
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = rec.get(word1);
        List<Integer> list2 = rec.get(word2);
        
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

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
