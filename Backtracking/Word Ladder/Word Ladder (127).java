public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int len = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            
            for (int i = 0; i < size; i++) {
                String peek = queue.poll();
                List<String> neighbors = getNeighbors(peek);
                
                for (String neighbor : neighbors) {
                    if (wordSet.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                    	    return len;
                    	}
                    	
                        queue.offer(neighbor);
                        wordSet.remove(neighbor);
                    }
                }
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
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.add(beginWord);
        queue2.add(endWord);
        wordSet.remove(beginWord);
        wordSet.remove(endWord);
        int len = 1;

        while (!queue1.isEmpty()) {
            int size = queue1.size();
            len++;
            
            for (int i = 0; i < size; i++) {
                String peek = queue1.poll();
                List<String> neighbors = getNeighbors(peek);
                
                for (String neighbor : neighbors) {
                    if (queue2.contains(neighbor)) {
                        return len;
                    }
                    
                    if (wordSet.contains(neighbor)) {
                        queue1.offer(neighbor);
                        wordSet.remove(neighbor);
                    }
                }
            }
            
            if (queue1.size() > queue2.size()) {
                Queue<String> temp = new LinkedList<>(queue1);
                queue1 = queue2;
                queue2 = temp;
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
