class Solution {
    public int numSimilarGroups(String[] A) {
        int N = A.length;
        boolean[] visited = new boolean[N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(A, i, visited);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(String[] A, int i, boolean[] visited) {
        visited[i] = true;
        
        for (int j = 0; j < A.length; j++) {
            if (!visited[j] && areSimilar(A[i], A[j])) {
                dfs(A, j, visited);
            }
        }
    }
    
    private boolean areSimilar(String s1, String s2) {
        int diff = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 0 || diff == 2;
    }
}
