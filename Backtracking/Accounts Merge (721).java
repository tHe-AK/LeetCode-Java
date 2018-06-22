class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> map = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
            
        for (List<String> account : accounts) {
            String name = account.get(0);
            
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                map.putIfAbsent(email, name);
                graph.putIfAbsent(email, new HashSet<>());
                
                if (i > 1) {
                    String neighbor = account.get(1);
                    graph.get(email).add(neighbor);
                    graph.get(neighbor).add(email);
                }
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        for (String account : map.keySet()) {
            if (!visited.contains(account)) {
                List<String> path = new ArrayList<>();
                dfs(account, graph, path, visited);
                Collections.sort(path);
                path.add(0, map.get(account));
                res.add(path);
            }
        }
        
        return res;
    }
    
    private void dfs(String account, Map<String, Set<String>> graph, List<String> path, Set<String> visited) {
        if (visited.contains(account)) {
            return;
        }
        
        visited.add(account);
        path.add(account);
        
        for (String neighbor : graph.get(account)) {
            dfs(neighbor, graph, path, visited);
        }        
    }
}
