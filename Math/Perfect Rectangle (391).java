public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        int area = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for (int[] ractangle : rectangles) {
            int x1 = ractangle[0];
            int y1 = ractangle[1];
            int x2 = ractangle[2];
            int y2 = ractangle[3];
            
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);
            
            updateSet(x1 + " " + y1, set);
            updateSet(x1 + " " + y2, set);
            updateSet(x2 + " " + y1, set);
            updateSet(x2 + " " + y2, set);
            
            area += (x2 - x1) * (y2 - y1);
        }
        
        if (set.size() != 4 || !set.contains(minX + " " + minY) || !set.contains(minX + " " + maxY) || !set.contains(maxX + " " + minY) || !set.contains(maxX + " " + maxY)) {
            return false;
        }
        
        return (maxX - minX) * (maxY - minY) == area;
    }
    
    private void updateSet(String str, Set<String> set) {
        if (set.contains(str)) {
            set.remove(str);
        } else {
            set.add(str);
        }
    }
}
