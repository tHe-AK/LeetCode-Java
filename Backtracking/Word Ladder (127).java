public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        return bfs(beginWord, endWord, new HashSet<String>(wordList));
    }
    
    private int bfs(String beginWord, String endWord, Set<String> wordList) {
        Set<String> curr = new HashSet<>();
        curr.add(beginWord);
        wordList.remove(beginWord);
        int len = 1;
        
        while (!curr.isEmpty()) {
            Set<String> next = new HashSet<>();
            len++;
            
            for (String str : curr) {
                List<String> neighbors = getNeighbors(str);
                
                for (String neighbor : neighbors) {
                    if (wordList.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                    	    return len;
                    	}
                    	
                        next.add(neighbor);
                    }
                }
            }
            
            wordList.removeAll(next);
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
