public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        
        if (!wordList.contains(endWord)) {
            return result;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        
        if (bfs(beginWord, endWord, new HashSet<String>(wordList), set1, set2, map, true)) {
            List<String> curr = new ArrayList<>();
            curr.add(beginWord);
        
            dfs(beginWord, endWord, map, curr, result);
        }
        
        
        return result;
    }
    
    private boolean bfs(String beginWord, String endWord, Set<String> wordList, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.size() > set2.size()) {
            return bfs(beginWord, endWord, wordList, set2, set1, map , !flip);
        }
        
        if (set1.isEmpty()) {
            return false;
        }
        
        wordList.removeAll(set1);
        wordList.removeAll(set2);
        Set<String> next = new HashSet<>();
        boolean isFound = false;
        
        for (String str : set1) {
            List<String> neighbors = getNeighbors(str);
            
            for (String neighbor : neighbors) {
                String key = flip ? str : neighbor;
                String val = flip ? neighbor : str;
                List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
                
                if (set2.contains(neighbor)) {
                    isFound = true;
                    list.add(val);
                    map.put(key, list);
                }
                
                if (wordList.contains(neighbor)) {
                    next.add(neighbor);
                    list.add(val);
                    map.put(key, list);
                }
            }
        }
        
        return isFound || bfs(beginWord, endWord, wordList, set2, next, map, !flip);
    }
    
    private void dfs(String beginWord, String endWord, Map<String, List<String>> map, List<String> curr, List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<String>(curr));
            return;
        }
   
        if (!map.containsKey(beginWord)) {
            return;
        }
           
        for (String neighbor : map.get(beginWord)) {
            curr.add(neighbor);
            dfs(neighbor, endWord, map, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
    
    private List<String> getNeighbors(String str) {
        List<String> neighbors = new ArrayList<>();
        
        for (int j = 0; j < str.length(); j++) {
            char[] chars = str.toCharArray();
                    
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != chars[j]) {
                    chars[j] = c;
                    String neighbor = new String(chars);;
                    neighbors.add(neighbor);
                }
            }
        }
        
        return neighbors;
    }
}

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        if (bfs(beginWord, endWord, new HashSet<String>(wordList), map)) {
            List<String> curr = new ArrayList<>();
            curr.add(beginWord);
        
            dfs(beginWord, endWord, map, curr, result);
        }
        
        
        return result;
    }
    
    private boolean bfs(String beginWord, String endWord, Set<String> wordList, Map<String, List<String>> map) {
        Set<String> curr = new HashSet<>();
        curr.add(beginWord);
        wordList.remove(beginWord);
        boolean isFound = false;
        
        while (!curr.isEmpty()) {
            Set<String> next = new HashSet<>();
            
            for (String str : curr) {
                map.put(str, new ArrayList<String>());
                List<String> neighbors = getNeighbors(str);
                
                for (String neighbor : neighbors) {
                    if (wordList.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                    	    isFound = true;
                    	}
                    	
                        next.add(neighbor);
                        map.get(str).add(neighbor);
                    }
                }
            }
            
            if (isFound) {
                break;
            }
            
            wordList.removeAll(next);
            curr = next;
        }
        
        return isFound;
    }
    
    private void dfs(String beginWord, String endWord, Map<String, List<String>> map, List<String> curr, List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<String>(curr));
            return;
        }
   
        if (!map.containsKey(beginWord)) {
            return;
        }
           
        for (String neighbor : map.get(beginWord)) {
            curr.add(neighbor);
            dfs(neighbor, endWord, map, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
    
    private List<String> getNeighbors(String str) {
        List<String> neighbors = new ArrayList<>();
        
        for (int j = 0; j < str.length(); j++) {
            char[] chars = str.toCharArray();
                    
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != chars[j]) {
                    chars[j] = c;
                    String neighbor = new String(chars);;
                    neighbors.add(neighbor);
                }
            }
        }
        
        return neighbors;
    }
}
