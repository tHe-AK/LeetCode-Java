class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>();
        
        for (String word : (A + " " + B).split("\\s+")) {
            if (set.contains(word)) {
                set.remove(word);
                visited.add(word);
            } else if (!visited.contains(word)) {
                set.add(word);
            }
        }
        
        return set.toArray(new String[0]);
    }
}
