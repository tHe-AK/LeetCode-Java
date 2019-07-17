class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(getDist(b), getDist(a)));
        
        for (int[] point : points) {
            queue.offer(point);
            
            if (queue.size() > K) {
                queue.poll();
            }
        }
        
        return queue.toArray(new int[0][0]);
    }
    
    private int getDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
