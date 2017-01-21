public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        wordSet.remove(beginWord);
        wordSet.remove(endWord);
        int len = 1;

        while (!set1.isEmpty()) {
            Set<String> next = new HashSet<>();
            len++;
            
            for (String str : set1) {
                List<String> neighbors = getNeighbors(str);
                
                for (String neighbor : neighbors) {
                    if (set2.contains(neighbor)) {
                        return len;
                    }
                    
                    if (wordSet.contains(neighbor)) {
                        next.add(neighbor);
                    }
                }
            }
            
            wordSet.removeAll(next);
            set1 = next;
            
            if (set1.size() > set2.size()) {
                Set<String> temp = new HashSet<>(set1);
                set1 = set2;
                set2 = temp;
            }
        }
        
        return 0;
    }
    
    private List<String> getNeighbors(String str) {
        List<String> neighbors = new ArrayList<>();
        
        for (int j = 0; j < str.length(); j++) {
            StringBuilder sb = new StringBuilder(str);
                    
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != str.charAt(j)) {
                    sb.setCharAt(j, c);
                    String neighbor = sb.toString();
                    neighbors.add(neighbor);
                }
            }
        }
        
        return neighbors;
    }
}

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        return bfs(beginWord, endWord, new HashSet<String>(wordList));
    }
    
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> curr = new HashSet<>();
        curr.add(beginWord);
        wordSet.remove(beginWord);
        int len = 1;
        
        while (!curr.isEmpty()) {
            Set<String> next = new HashSet<>();
            len++;
            
            for (String str : curr) {
                List<String> neighbors = getNeighbors(str);
                
                for (String neighbor : neighbors) {
                    if (wordSet.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                    	    return len;
                    	}
                    	
                        next.add(neighbor);
                    }
                }
            }
            
            wordSet.removeAll(next);
            curr = next;
        }
        
        return 0;
    }
    
    private List<String> getNeighbors(String str) {
        List<String> neighbors = new ArrayList<>();
        
        for (int j = 0; j < str.length(); j++) {
            StringBuilder sb = new StringBuilder(str);
                    
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != str.charAt(j)) {
                    sb.setCharAt(j, c);
                    String neighbor = sb.toString();
                    neighbors.add(neighbor);
                }
            }
        }
        
        return neighbors;
    }
}
