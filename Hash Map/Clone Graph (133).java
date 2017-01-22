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
