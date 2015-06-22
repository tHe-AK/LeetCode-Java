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

class Trie {
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
    
    public TrieNode searchNode(String word) {
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

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.insert(word);
        }
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                helper(i, j, board, visited, "", trie, result);
            }
        }
        
        return result;
    }
    
    private void helper(int i, int j, char[][] board, boolean[][] visited, String cur, Trie trie, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        
        cur += board[i][j];
        
        if (!trie.startsWith(cur)) {
            return;
        }
        
        if (trie.search(cur)) {
            trie.searchNode(cur).isLeaf = false;
            result.add(cur);
        }
        
        visited[i][j] = true;
        
        helper(i - 1, j, board, visited, cur, trie, result);
        helper(i + 1, j, board, visited, cur, trie, result);
        helper(i, j - 1, board, visited, cur, trie, result);
        helper(i, j + 1, board, visited, cur, trie, result);
        
        visited[i][j] = false;
    }
}
