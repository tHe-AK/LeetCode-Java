class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        
        if (dead.contains("0000")) {
            return -1;
        }
        
        int depth = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            
            for (int i = 0; i < len; i++) {
                String peek = queue.poll();
                
                if (peek.equals(target)) {
                    return depth;
                } else {
                    List<String> neighbors = getNeighbors(peek);
                    
                    for (String neighbor : neighbors) {
                        if (!visited.contains(neighbor) && !dead.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
            
            depth++;
        }
        
        return -1;
    }
    
    private List<String> getNeighbors(String str) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            String pre = str.substring(0, i);
            String post = str.substring(i + 1);
            list.add(pre + ((digit + 1) % 10) + post);
            list.add(pre + ((digit + 9) % 10) + post);
        }
        
        return list;
    }
}
