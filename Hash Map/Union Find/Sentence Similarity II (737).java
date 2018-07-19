class UnionFind {
    Map<String, String> map;
    
    public UnionFind() {
        map = new HashMap<>();
    }
    
    public void insert(String str) {
        map.putIfAbsent(str, str);
    }
    
    public String find(String child) {
        if (!map.containsKey(child)) {
            return null;
        }
        
        String parent = child;
        
        while (parent != map.get(parent)) {
            parent = map.get(parent);
        }
        
        map.put(child, parent);
        return parent;
    }
    
    public void union(String child1, String child2) {
        String parent1 = find(child1);
        String parent2 = find(child2);
        
        if (parent1 != parent2) {
            map.put(parent1, parent2);
        }
    }
}

public class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
        UnionFind uf = new UnionFind();
        
        for (String[] pair : pairs) {
            uf.insert(pair[0]);
            uf.insert(pair[1]);
            uf.union(pair[0], pair[1]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            
            if (word1.equals(word2)) {
                continue;
            }
            
            String parent1 = uf.find(word1);
            String parent2 = uf.find(word2);
            
            if (parent1 == null || parent2 == null || !uf.find(word1).equals(uf.find(word2))) {
                return false;
            }
        }
        
        return true;
    }
}
