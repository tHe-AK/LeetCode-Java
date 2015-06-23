class GraphNode {
    int label;
    List<GraphNode> neighbors = new ArrayList<GraphNode>();
    
    GraphNode(int x) {
        label = x;
        neighbors = new ArrayList<GraphNode>();
    }
}

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return null;
        }
        
        GraphNode[] rec = new GraphNode[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<GraphNode> seq = new ArrayList<GraphNode>();
        
        for (int i = 0; i < numCourses; i++) {
            rec[i] = new GraphNode(i);
        }
        
        for (int[] pair : prerequisites) {
            rec[pair[1]].neighbors.add(rec[pair[0]]);
        }
        
        for (GraphNode node : rec) {
            if (!helper(node, visited, seq)) {
                return new int[0];
            }
        }
        
        int[] result = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            result[i] = seq.get(numCourses - 1 - i).label;
        }
 
        return result;
    }
    
    private boolean helper(GraphNode node, boolean[] visited, List<GraphNode> seq) {
        if (seq.contains(node)) {
            return true;
        }
        
        int label = node.label;
        
        if (visited[label]) {
            return false;
        }

        visited[label] = true;
        
        for (GraphNode neighbor : node.neighbors) {
            if (!helper(neighbor, visited, seq)) {
                return false;
            }
        }
        
        visited[label] = false;
        seq.add(node);
        
        return true;
    }
}
