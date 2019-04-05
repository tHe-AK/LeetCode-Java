class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(graph, 0, curr, result);
        return result;
    }
    
    private void dfs(int[][] graph, int i, List<Integer> curr, List<List<Integer>> result) {
        if (i == graph.length - 1) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int j : graph[i]) {
            curr.add(j);
            dfs(graph, j, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        return dfs(graph, 0, map);
    }
    
    private List<List<Integer>> dfs(int[][] graph, int i, Map<Integer, List<List<Integer>>> map) {
        if (map.containsKey(i)) {
            return map.get(i);
        }
        
        List<List<Integer>> paths = new ArrayList<>();

        if (i == graph.length - 1) {
            paths.add(Arrays.asList(new Integer[] { i }));
        } else {
            for (int j : graph[i]) {
                for (List<Integer> list : dfs(graph, j, map)) {
                    List<Integer> path = new LinkedList<>(list);
                    path.add(0, i);
                    paths.add(path);
                }
            }
        }
        
        map.put(i, paths);
        return paths;
    }
}
