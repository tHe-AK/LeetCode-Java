public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null) {
            throw new IllegalArgumentException();
        }
        
        Set<String> set = new HashSet<String>();
        int area = 0;
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        
        for (int[] ractangle : rectangles) {
            int x1 = ractangle[0];
            int y1 = ractangle[1];
            int x2 = ractangle[2];
            int y2 = ractangle[3];
            
            xMin = Math.min(xMin, x1);
            yMin = Math.min(yMin, y1);
            xMax = Math.max(xMax, x2);
            yMax = Math.max(yMax, y2);
            
            helper(x1 + " " + y1, set);
            helper(x1 + " " + y2, set);
            helper(x2 + " " + y1, set);
            helper(x2 + " " + y2, set);
            
            area += (x2 - x1) * (y2 - y1);
        }
        
        if (set.size() != 4 || !set.contains(xMin + " " + yMin) || !set.contains(xMin + " " + yMax) || !set.contains(xMax + " " + yMin) || !set.contains(xMax + " " + yMax)) {
            return false;
        }
        
        return (xMax - xMin) * (yMax - yMin) == area;
    }
    
    private void helper(String str, Set<String> set) {
        if (set.contains(str)) {
            set.remove(str);
        } else {
            set.add(str);
        }
    }
}
