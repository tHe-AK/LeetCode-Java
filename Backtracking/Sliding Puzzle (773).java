class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] delta = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 3, 5, 1 }, { 4, 2 } };
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String str = "";
        int dist = 0;

        for (int[] row : board) {
            for (int i : row) {
                str += i;
            }
        }
        
        queue.offer(str);
        visited.add(str);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String peek = queue.poll();
                
                if (peek.equals("123450")) {
                    return dist;
                }
                
                int idx = peek.indexOf("0");
                
                for (int j : delta[idx]) {
                    String next = swap(peek, idx, j);
                    
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
                
            dist++;
        }
        
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        if (i > j) {
            return swap(str, j, i);
        }
        
        return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i) + str.substring(j + 1);
    } 
}
