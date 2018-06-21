class Solution {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        String str = "";
        
        for (String word : words) {
            set.add(word);
        }
        
        for (String word : words) {
            int len = word.length();
            int end = len;
            
            while (end > 0 && set.contains(word.substring(0, end))) {
                end--;
            }
            
            if (end == 0 && (str.length() < len || (str.length() == len && word.compareTo(str) < 0))) {
                str = word;
            } 
        }
            
        return str;
    }
}

class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.insert(word);
        }
         
        return trie.longestWord();
    }
}

class TrieNode {
    public TrieNode[] nodes;
    public boolean isEnd;
    
    public TrieNode() {
        nodes = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
        root.isEnd = true;
    }
    
    public void insert(String str) {
        TrieNode curr = root;
        
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            
            if (curr.nodes[idx] == null) {
                curr.nodes[idx] = new TrieNode();
            }
            
            curr = curr.nodes[idx];
        }
        
        curr.isEnd = true;
    }
    
    public String longestWord() {
        String[] res = { "" };
        dfs(root, "", res);
        return res[0];
    }
    
    private void dfs(TrieNode root, String word, String[] res) {
        if (!root.isEnd) {
            return;
        }
        
        if (word.length() > res[0].length()) {
            res[0] = word;
        }
        
        for (int i = 0; i < root.nodes.length; i++) {
            TrieNode node = root.nodes[i];
            if (node != null) {
                dfs(node, word + (char)('a' + i), res);
            }
        }
    }
}
