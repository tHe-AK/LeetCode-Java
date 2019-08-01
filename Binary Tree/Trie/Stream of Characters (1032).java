class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;
    
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String str) {
        TrieNode node = root;
        
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            
            node = node.children[idx];
        }
        
        node.isEnd = true;
    }
    
    public boolean query(String str) {
        TrieNode node = root;
        
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            
            if (node.children[idx] != null) {
                node = node.children[idx];
                
                if (node.isEnd) {
                    return true;
                }
            } else {
                return false;
            }
        }
        
        return node.isEnd;
    }
}

public class StreamChecker {
    private Trie trie;
    private String str;
    private int max;

    public StreamChecker(String[] words) {
        trie = new Trie();
        str = "";
        max = 0;
        
        for (String word : words) {
            max = Math.max(max, word.length());
            trie.insert(new StringBuilder(word).reverse().toString());
        }
    }
    
    public boolean query(char letter) {
        str = letter + str;
        
        if (str.length() > max) {
            str = str.substring(0, max);
        }

        return trie.query(str);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
