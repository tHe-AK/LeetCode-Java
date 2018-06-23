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

        for (String email : map.keySet()) {
            if (!visited.contains(email)) {
                List<String> path = new ArrayList<>();
                dfs(email, graph, path, visited);
                Collections.sort(path);
                path.add(0, map.get(email));
                res.add(path);
            }
        }
        
        return res;
    }
    
    private void dfs(String email, Map<String, Set<String>> graph, List<String> path, Set<String> visited) {
        if (visited.contains(email)) {
            return;
        }
        
        visited.add(email);
        path.add(email);
        
        for (String neighbor : graph.get(email)) {
            dfs(neighbor, graph, path, visited);
        }        
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> map = new HashMap<>();
        UnionFind uf = new UnionFind();
            
        for (List<String> account : accounts) {
            String name = account.get(0);
            
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                map.putIfAbsent(email, name);
                uf.add(email);
                
                if (i > 1) {
                    String neighbor = account.get(1);
                    uf.union(email, neighbor);
                }
            }
        }
        
        Map<String, Set<String>> graph = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String email : map.keySet()) {
            String parent = uf.find(email);
            graph.computeIfAbsent(parent, k -> new HashSet<>()).add(email);
        }
        
        for (String email : graph.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(map.get(email));
            List<String> emails = new ArrayList<>(graph.get(email));
            Collections.sort(emails);
            list.addAll(emails);
            res.add(list);
        }
        
        return res;
    }
}

class UnionFind {
    private Map<String, String> map;
    
    public UnionFind() {
        map = new HashMap<>();
    }
    
    public void add(String str) {
        map.putIfAbsent(str, str);
    }
    
    public String find(String child) {
        String parent = child;
        
        while (!map.get(parent).equals(parent)) {
            parent = map.get(parent);
        }
        
        map.put(child, parent);
        return parent;
    }
    
    public void union(String child1, String child2) {
        String parent1 = find(child1);
        String parent2 = find(child2);
        
        if (!parent1.equals(parent2)) {
            map.put(parent1, parent2);
        }
    }
}
