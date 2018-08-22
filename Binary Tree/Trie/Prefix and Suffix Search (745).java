class WordFilter {
    private class TrieNode {
        public TrieNode[] children;
        public int weight;
            
        public TrieNode() {
            children = new TrieNode[27];
            weight = -1;
        }
    }
    
    private class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String path, int weight) {
            TrieNode node = root;
            
            for (int i = 0; i < path.length(); i++) {
                char ch = path.charAt(i);
                int idx = ch == '#' ? 26 : ch - 'a';
                
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                
                node = node.children[idx];
                node.weight = weight;
            }
        }
        
        public Integer search(String path) {
            TrieNode node = root;

            for (int i = 0; i < path.length(); i++) {
                char ch = path.charAt(i);
                int idx = ch == '#' ? 26 : ch - 'a';

                if (node.children[idx] == null) {
                    return null;
                }
                
                node = node.children[idx];
            }
            
            return node.weight;
        }
    }
    
    private Trie trie;

    public WordFilter(String[] words) {
        trie = new Trie();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            trie.insert("#" + word, i);
            
            for (int j = 0; j < word.length(); j++) {
                String path = word.substring(j) + "#" + word;
                trie.insert(path, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        Integer weight = trie.search(suffix + "#" + prefix);
        return weight == null ? -1 : weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
