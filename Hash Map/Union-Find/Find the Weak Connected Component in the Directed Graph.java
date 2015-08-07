/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
 
class UnionFind {
    HashMap<Integer, Integer> rec;
    
    UnionFind() {
        rec = new HashMap<Integer, Integer>();
    }
    
    boolean contain(int child) {
        return rec.containsKey(child);
    }
    
    void add(int child) {
        if (!contain(child)) {
            rec.put(child, child);
        }
    }
    
    int find(int child) {
        if (!contain(child)) {
            throw new RuntimeException();
        }
        
        while (child != rec.get(child)) {
            child = rec.get(child);
        }
            
        return child;
    }
    
    void union(int child1, int child2) {
        int parent1 = find(child1);
        int parent2 = find(child2);
        
        if (parent1 != parent2) {
            rec.put(parent1, parent2);
        }
    }
    
    List<List<Integer>> print() {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (Integer child : rec.keySet()) {
            int parent = find(child);
            
            if (map.containsKey(parent)) {
                map.get(parent).add(child);
            }
            else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(child);
                map.put(parent, list);
            }
        }
        
        for (Integer parent : map.keySet()) {
            List<Integer> list = map.get(parent);
            Collections.sort(list);
            result.add(list);
        }
        
        return result;
    }
}

public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        if (nodes == null) {
            throw new IllegalArgumentException();
        }
        
        UnionFind uf = new UnionFind();
        
        for (DirectedGraphNode node : nodes) {
            uf.add(node.label);
            
            for (DirectedGraphNode neighbor : node.neighbors) {
                uf.add(neighbor.label);
                uf.union(node.label, neighbor.label);
            }
        }
        
        return uf.print();
    }
}
