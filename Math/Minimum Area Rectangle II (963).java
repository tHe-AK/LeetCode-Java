class Solution {
    public double minAreaFreeRect(int[][] points) {
        int N = points.length;
        double res = Double.MAX_VALUE;
        Map<String, List<int[]>> map = new HashMap<>();
        
        if (N < 4) {
            return 0;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long length = points[i][0] - points[j][0];
                long width = points[i][1] - points[j][1];
                long dist = length * length + width * width;
                double centerX = (points[j][0] + points[i][0]) / 2.0;
                double centerY = (points[j][1] + points[i][1]) / 2.0;
                String key = dist + " " + centerX + " " + centerY;
                map.putIfAbsent(key, new ArrayList<int[]>());
                map.get(key).add(new int[] { i, j });
            }
        }
        
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {  
                List<int[]> list = map.get(key);
                
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        int p1 = list.get(i)[0];
                        int p2 = list.get(j)[0];
                        int p3 = list.get(j)[1];
                        long length1 = points[p1][0] - points[p2][0];
                        long width1 = points[p1][1] - points[p2][1];
                        long length2 = points[p1][0] - points[p3][0];
                        long width2 = points[p1][1] - points[p3][1];
                        double dist1 = Math.sqrt(length1 * length1 + width1 * width1); 
                        double dist2 = Math.sqrt(length2 * length2 + width2 * width2); 
                        double area = dist1 * dist2; 
                        res = Math.min(res, area);
                    }
                }
            }
        }
        
        return res == Double.MAX_VALUE ? 0 : res;
    }
}
