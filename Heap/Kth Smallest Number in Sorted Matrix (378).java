class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getCount(matrix, mid);
            
            if (count >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private int getCount(int[][] matrix, int k) {
        int count = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            count += binarySearch(matrix[i], k);
        }
        
        return count;
    }
    
    private int binarySearch(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (array[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
}

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
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
