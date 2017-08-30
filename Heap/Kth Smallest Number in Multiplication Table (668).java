class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getCount(m, n, mid);
            
            if (k <= count) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private int getCount(int m, int n, int k) {
        int count = 0;
        
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, k / i);
        }
        
        return count;
    }
}

class Solution {
    public int findKthNumber(int m, int n, int k) {
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0] * a[1], b[0] * b[1]));
        queue.offer(new int[] { 1, 1 });
        
        while (k-- > 1) {
            int[] peek = queue.poll();
            int i = peek[0];
            int j = peek[1];
            
            if (j == 1 && i + 1 <= m) {
                queue.offer(new int[] { i + 1, 1 });
            }
            
            if (j + 1 <= n) {
                queue.offer(new int[] { i, j + 1 });
            }
        }
        
        int[] peek = queue.poll();
        
        return peek[0] * peek[1];
    }
}
