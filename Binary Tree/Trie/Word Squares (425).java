class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private List<String> words;

    public TrieNode() {
        links = new TrieNode[R];
        words = new ArrayList<String>();
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
    
    public List<String> getWords() {
        return words;
    }
    
    public void addWord(String word) {
        words.add(word);
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        node.addWord(word);
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            
            node = node.get(ch);
            node.addWord(word);
        }
    }
    
    public List<String> searchPrefix(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
           char ch = word.charAt(i);
           
           if (node.containsKey(ch)) {
               node = node.get(ch);
           } else {
               return new ArrayList<>();
           }
        }
        
        return node.getWords();
    }
}

public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        
        if (words.length == 0) {
            return result;
        }
        
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.insert(word);
        }
        
        dfs(trie, words[0].length(), new ArrayList<>(), result);
        
        return result;
    }
    
    private void dfs(Trie trie, int size, List<String> curr, List<List<String>> result) {
        if (curr.size() == size) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        String prefix = "";
        int idx = curr.size();
        
        for (String word : curr) {
            prefix += word.charAt(idx);
        }
        
        List<String> list = trie.searchPrefix(prefix);
        
        for (String word : list) {
            curr.add(word);
            dfs(trie, size, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
