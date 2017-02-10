public class UnionFind<T> {
    private Map<T, T> rec;
    private int count;
    
    public UnionFind() {
        rec = new HashMap<>();
        count = 0;
    }
    
    public int count() {
        return count;
    }
    
    public boolean contains(T child) {
        return rec.containsKey(child);
    }
    
    public void add(T child) {
        if (!contains(child)) {
            rec.put(child, child);
            count++;
        }
    }
    
    public T find(T child) {
        if (!contains(child)) {
            return null;
        }
        
        T root = child;
        
        while (root != rec.get(root)) {
            root = rec.get(root);
        }
        
        rec.put(child, root);
            
        return root;
    }
    
    public void union(T child1, T child2) {
        if (!contains(child1) || !contains(child2)) {
            return;
        }
        
        T root1 = find(child1);
        T root2 = find(child2);
        
        if (root1 != root2) {
            rec.put(root1, root2);
            count--;
        }
    }
}
