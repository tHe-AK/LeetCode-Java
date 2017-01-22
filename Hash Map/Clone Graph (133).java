/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        return cloneGraph(node, map);
    }
    
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor, map));
        }
        
        return clone;
    }
}

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        map.put(node, new UndirectedGraphNode(node.label));
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode peek = queue.poll();
            
            for (UndirectedGraphNode neighbor : peek.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                
                map.get(peek).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}
