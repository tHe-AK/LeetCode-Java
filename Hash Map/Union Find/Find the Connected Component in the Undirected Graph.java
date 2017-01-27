/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
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
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        if (nodes == null) {
            throw new IllegalArgumentException();
        }
        
        UnionFind uf = new UnionFind();

        for (UndirectedGraphNode node : nodes) {
            if (!uf.contain(node.label)) {
                uf.add(node.label);
            }
            
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!uf.contain(node.label)) {
                    uf.add(neighbor.label);
                }
                
                uf.union(node.label, neighbor.label);
            }
        }
        
        return uf.print();
    }
}

public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        if (nodes == null) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                List<Integer> cur = new ArrayList<Integer>();
                helper(node, visited, cur);
                Collections.sort(cur);
                result.add(cur);
            }
        }
        
        return result;
    }
    
    private void helper(UndirectedGraphNode node, HashSet<UndirectedGraphNode> visited, List<Integer> cur) {
        visited.add(node);
        cur.add(node.label);
        
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                helper(neighbor, visited, cur);
            }
        }
    }
}

public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        if (nodes == null) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                List<Integer> cur = helper(node, visited);
                Collections.sort(cur);
                result.add(cur);
            }
        }
        
        return result;
    }
    
    private List<Integer> helper(UndirectedGraphNode node, HashSet<UndirectedGraphNode> visited) {
        visited.add(node);
        List<Integer> result = new ArrayList<Integer>();
        result.add(node.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode peek = queue.poll();
            
            for (UndirectedGraphNode neighbor : peek.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    result.add(neighbor.label);
                    queue.add(neighbor);
                }
            }
        }
        
        return result;
    }
}
