public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k < 0) {
            throw new IllegalArgumentException();
        }
        
        List<int[]> result = new ArrayList<int[]>();
        
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        
        int[] rec = new int[nums1.length];
        
        while (k > 0) {
            int min = Integer.MAX_VALUE;
            int x = -1;

            for (int i = 0; i < rec.length; i++) {
                if (rec[i] >= 0 && rec[i] < nums2.length) {
                    int sum = nums1[i] + nums2[rec[i]];
                    
                    if (sum < min) {
                        min = sum;
                        x = i;
                    }
                }
            }
            
            if (x == -1) {
                break;
            }
            
            result.add(new int[] {nums1[x], nums2[rec[x]]});
            
            if (rec[x] < nums2.length) {
                rec[x]++;
            }
            
            k--;
        }
        
        return result;
    }
}
