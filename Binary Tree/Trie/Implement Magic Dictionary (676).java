class MagicDictionary {
    private Map<String, Set<String>> map;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                map.putIfAbsent(key, new HashSet<>());
                map.get(key).add(word);
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + "*" + word.substring(i + 1);
            
            if (map.containsKey(key)) {
                Set<String> val = map.get(key);
                
                if (!val.contains(word) || val.size() > 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

class MagicDictionary {
    private class TrieNode {
        public TrieNode[] links;
        public boolean isEnd;
        
        public TrieNode() {
            links = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            TrieNode node = root;
            
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                
                if (node.links[idx] == null) {
                    node.links[idx] = new TrieNode();
                }
                
                node = node.links[idx];
            }
            
            node.isEnd = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return search(root, word, 0, false);
    }
    
    private boolean search(TrieNode node, String word, int idx, boolean isChanged) {
        if (node == null) {
            return false;
        }
        
        if (idx == word.length()) {
            return node.isEnd && isChanged;
        }
        
        int i = word.charAt(idx) - 'a';
        
        if (isChanged) {
            return search(node.links[i], word, idx + 1, isChanged);
        } else {
            for (int j = 0; j < 26; j++) {
                if (search(node.links[j], word, idx + 1, j != i ? true : false)) {
                    return true;
                }
            }
            
            return false;
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
