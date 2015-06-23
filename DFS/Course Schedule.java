class GraphNode {
    int label;
    List<GraphNode> neighbors = new ArrayList<GraphNode>();
    
    GraphNode(int x) {
        label = x;
        neighbors = new ArrayList<GraphNode>();
    }
}

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return false;
        }
        
        GraphNode[] rec = new GraphNode[numCourses];
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            rec[i] = new GraphNode(i);
        }
        
        for (int[] pair : prerequisites) {
            rec[pair[1]].neighbors.add(rec[pair[0]]);
        }
        
        for (GraphNode node : rec) {
            if (!helper(node, visited)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean helper(GraphNode node, boolean[] visited) {
        int label = node.label;
        
        if (visited[label]) {
            return false;
        }

        visited[label] = true;
        
        for (GraphNode neighbor : node.neighbors) {
            if (!helper(neighbor, visited)) {
                return false;
            }
        }
        
        visited[label] = false;
        
        return true;
    }
}
