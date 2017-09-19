class MapSum {
    private class TrieNode {
        public Map<Character, TrieNode> links;
        public int sum;
        
        public TrieNode() {
            links = new HashMap<>();
            sum = 0;
        }
    }
    
    private TrieNode root;
    private Map<String, Integer> map;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            node.links.putIfAbsent(ch, new TrieNode());
            node = node.links.get(ch);
            node.sum += diff;
        }
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            
            if (!node.links.containsKey(ch)) {
                return 0;
            } else {
                node = node.links.get(ch);
            }
        }
        
        return node.sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
