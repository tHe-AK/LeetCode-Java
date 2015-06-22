class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
        
    // Initialize your data structure here.
    public TrieNode() {
    }
    
    public TrieNode(char c) {
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            }
            else {
                TrieNode next = new TrieNode(c);
                cur.children.put(c, next);
                cur = next;
            }
            
            if (i == word.length() - 1) {
                cur.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        
        if (node != null && node.isLeaf) {
            return true;
        }
        else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        
        if (node != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private TrieNode searchNode(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (!cur.children.containsKey(c)) {
                return null;
            }
            
            cur = cur.children.get(c);
        }
        
        return cur;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
