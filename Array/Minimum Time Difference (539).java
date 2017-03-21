public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = 24 * 60;
        boolean[] visited = new boolean[n];
        
        for (String timePoint : timePoints) {
            String[] strs = timePoint.split(":");
            int h = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
            int idx = h * 60 + m;
            
            if (visited[idx]) {
                return 0;
            }
            
            visited[idx] = true;
        }
        
        Integer prev = null;
        Integer first = null;
        Integer last = null;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                if (prev == null) {
                    first = i;
                } else {
                    min = Math.min(min, i - prev);
                }
                
                last = i;
                prev = i;
            }
        }
        
        min = Math.min(min, first + n - last);
        
        return min;
    }
}
