class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getCount(matrix, mid);
            
            if (k <= count) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low - 1;
    }
    
    private int getCount(int[][] matrix, int k) {
        int count = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            int idx = Arrays.binarySearch(matrix[i], k);
            
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            count += idx;
        }
        
        return count;
    }
}

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] { matrix[0][0], 0, 0 });
        
        while (k-- > 1) {
            int[] peek = queue.poll();
            int i = peek[1];
            int j = peek[2];

            if (j == 0 && i + 1 < matrix.length) {
                queue.offer(new int[] { matrix[i + 1][j], i + 1, j });
            }
            
            if (j + 1 < matrix[0].length) {
                queue.offer(new int[] { matrix[i][j + 1], i, j + 1 });
            }
        }
        
        return queue.poll()[0];
    }
}
