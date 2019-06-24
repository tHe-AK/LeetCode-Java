class Solution {
    public int catMouseGame(int[][] graph) {
        int N = graph.length;
        int[][][] res = new int[N][N][2];
        int[][][] outdegree = new int[N][N][2];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                outdegree[i][j][0] = graph[i].length;
                outdegree[i][j][1] = graph[j].length;
                
                for (int k : graph[j]) {
                    if (k == 0) {
                        outdegree[i][j][1]--;
                        break;
                    }
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 1; i < N; i++) {
            for (int k = 0; k < 2; k++) {
                res[0][i][k] = 1;
                queue.offer(new int[] { 0, i, k, 1 });
                res[i][i][k] = 2;
                queue.offer(new int[] { i, i, k, 2 });
            }
        }
        
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            int prevMouse = peek[0];
            int prevCat = peek[1];
            int prevTurn = peek[2];
            int color = peek[3];
            int turn = 1 - prevTurn;
            
            for (int next : graph[turn == 0 ? prevMouse : prevCat]) {
                int mouse = turn == 0 ? next : prevMouse;
                int cat = turn == 1 ? next : prevCat;
                
                if (cat == 0) {
                    continue;
                }
                
                if (res[mouse][cat][turn] > 0) {
                    continue;
                }
                
                if (turn + 1 == color || --outdegree[mouse][cat][turn] == 0) {
                    if (mouse == 1 && cat == 2 && turn == 0) {
                        return color;
                    }
                    
                    res[mouse][cat][turn] = color;
                    queue.offer(new int[] { mouse, cat, turn, color });
                }
            }
        }
        
        return res[1][2][0];
    }
}
