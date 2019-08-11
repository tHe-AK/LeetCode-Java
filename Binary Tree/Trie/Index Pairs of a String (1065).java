class TrieNode {
    public TrieNode[] map;
    public boolean isEnd;
    
    public TrieNode() {
        map = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    private TrieNode root;
    
    public Trie(String[] words) {
        root = new TrieNode();
        
        for (String word : words) {
            insert(word);
        }
    }
    
    private void insert(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            
            if (node.map[idx] == null) {
                node.map[idx] = new TrieNode();
            }
            
            node = node.map[idx];
        }
        
        node.isEnd = true;
    }
    
    public List<int[]> search(String word, int i) {
        List<int[]> list = new ArrayList<>();
        TrieNode node = root;

        for (int j = i; j < word.length(); j++) {
            int idx = word.charAt(j) - 'a';
            
            if (node.map[idx] == null) {
                break;
            }
            
            node = node.map[idx];
            
            if (node.isEnd) {
                list.add(new int[] { i, j });
            }
        }
        
        return list;
    }
}

public class Solution {
    public int[][] indexPairs(String text, String[] words) {
        Trie trie = new Trie(words);
        List<int[]> res = new ArrayList<>();
        
        for (int i = 0; i < text.length(); i++) {
            res.addAll(trie.search(text, i));
        }
        
        return res.toArray(new int[0][0]);
    }
}
