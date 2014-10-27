class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
};

public class Solution {
    public List<Integer> topologicalSorting(List<DirectedGraphNode> nodes) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (nodes == null || nodes.size() == 0) {
            return result;
        }
        
        HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        
        for (DirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                helper(node, visited, result);
            }
        }
        
        Collections.reverse(result);
        
        return result;        
    }
    
    private void helper(DirectedGraphNode node, HashSet<DirectedGraphNode> visited, ArrayList<Integer> result) {
        visited.add(node);
        
        for (DirectedGraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                helper(neighbor, visited, stack);
            }
        }
        
        result.add(node.label);
    }
}
