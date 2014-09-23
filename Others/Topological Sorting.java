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
        Stack<Integer> stack = new Stack<Integer>();
        
        for (DirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                helper(node, visited, stack);
            }
        }
        
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        
        return result;        
    }
    
    private void helper(DirectedGraphNode node, HashSet<DirectedGraphNode> visited, Stack<Integer> stack) {
        visited.add(node);
        
        for (DirectedGraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                helper(neighbor, visited, stack);
            }
        }
        
        stack.add(node.label);
    }
}
