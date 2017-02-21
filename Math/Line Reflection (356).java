public class Solution {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            String str = point[0] + " " + point[1];
            set.add(str);
        }
        
        int sum = min + max;
        
        for (int[] point : points) {
            String str = (sum - point[0]) + " " + point[1];
            
            if (!set.contains(str)) {
                return false;
            }
        }
        
        return true;
    }
}
