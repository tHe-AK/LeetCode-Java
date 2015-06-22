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

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }
    
    private boolean searchHelper(TrieNode root, int i, String word) {
        if (i == word.length()) {
            if (root.isLeaf) {
                return true;
            }
            else {
                return false;
            }
        }
        
        char c = word.charAt(i);
            
        if (c != '.') {
            if (!root.children.containsKey(c)) {
                return false;
            }
            else {
                return searchHelper(root.children.get(c), i + 1, word);
            }
        }
        else {
            for (Character key : root.children.keySet()) {
                if (searchHelper(root.children.get(key), i + 1, word)) {
                    return true;
                }
            }
            
            return false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
