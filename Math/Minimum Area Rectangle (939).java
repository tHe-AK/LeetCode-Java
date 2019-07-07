class Solution {
    public int minAreaRect(int[][] points) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            map.putIfAbsent(x, new HashSet<>());
            map.get(x).add(y);
        }
        
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                if (x1 != x2 && y1 != y2 && map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                    min = Math.min(min, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
