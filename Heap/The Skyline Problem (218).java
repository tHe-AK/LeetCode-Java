public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        
        for (int[] building : buildings) {
            points.add(new int[] { building[0], building[2] });
            points.add(new int[] { building[1], -building[2] });
        }
        
        Collections.sort(points, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p1[0] - p2[0];
            } else {
                return p2[1] - p1[1];
            }
        });
        
        Queue<Integer> pq = new PriorityQueue<>((y1, y2) -> y2 - y1);
        int prev = 0;
        pq.offer(0);
        
        for (int[] point : points) {
            if (point[1] > 0) {
                pq.offer(point[1]);
            } else {
                pq.remove(-point[1]);
            }
            
            int curr = pq.peek();
            
            if (curr != prev) {
                result.add(new int[] { point[0], curr });
                prev = curr;
            }
        }
        
        return result;
    }
}
