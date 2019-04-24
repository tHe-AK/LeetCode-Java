class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int depth = 0;
        
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.putIfAbsent(routes[i][j], new ArrayList<>());
                map.get(routes[i][j]).add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int peek = queue.poll();
                
                for (int bus : map.get(peek)) {
                    if (!visited.contains(bus)) {
                        visited.add(bus);
                        
                        for (int stop : routes[bus]) {
                            if (stop == T) {
                                return depth;
                            }
                                
                            queue.offer(stop);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}
