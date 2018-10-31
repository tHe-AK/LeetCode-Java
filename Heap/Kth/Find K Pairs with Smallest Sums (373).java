public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<int[]> result = new ArrayList<>();

        if (len1 == 0 || len2 == 0) {
            return result;
        }
        
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        queue.offer(new int[] { nums1[0] + nums2[0], 0, 0 });
        
        while (!queue.isEmpty() && k-- > 0) {
            int[] peek = queue.poll();
            int i = peek[1];
            int j = peek[2];
            result.add(new int[] { nums1[i], nums2[j] });
            
            if (j == 0 && i + 1 < len1) {
                queue.offer(new int[] { nums1[i + 1] + nums2[j], i + 1, j });
            }
            
            if (j + 1 < len2) {
                queue.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            }
        }
        
        return result;
    }
}
