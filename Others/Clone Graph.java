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
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        hashMap.put(node, new UndirectedGraphNode(node.label));
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode peek = queue.poll();
            
            for (UndirectedGraphNode neighbor : peek.neighbors) {
                if (!hashMap.containsKey(neighbor)) {
                    hashMap.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                
                hashMap.get(peek).neighbors.add(hashMap.get(neighbor));
            }
        }
        
        return hashMap.get(node);
    }
}
