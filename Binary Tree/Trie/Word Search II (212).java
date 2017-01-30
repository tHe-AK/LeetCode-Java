class TrieNode {
    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            
            node = node.get(currentChar);
        }
        
        node.setEnd();
    }
    
    /** search a prefix or whole key in trie and returns the node where search ends. */
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        
        return node;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        
        return node != null;
    }
}

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] delta = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            trie.insert(word);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, visited, "", delta, trie, result);
            }
        }
        
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, boolean[][] visited, String word, int[][] delta, Trie trie, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        
        word += board[i][j];
        
        if (!trie.startsWith(word)) {
            return;
        }
        
        if (trie.search(word) && !result.contains(word)) {
            result.add(word);
        }
        
        visited[i][j] = true;
            
        for (int k = 0; k < delta.length; k++) {
            int x = i + delta[k][0];
            int y = j + delta[k][1];
                
            dfs(board, x, y, visited, word, delta, trie, result);
        }
            
        visited[i][j] = false;
    }
}
