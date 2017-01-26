class Bucket {
    int start;
    int end;
    boolean isUsed;
    
    Bucket() {
        start = Integer.MAX_VALUE;
        end = Integer.MIN_VALUE;
        isUsed = false;
    }
}

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        
        int len = nums.length;
        Bucket[] buckets = new Bucket[len];
        
        for (int i = 0; i < len; i++) {
            buckets[i] = new Bucket();
        }
        
        int min = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        double size = 1.0 * (max - min) / (len - 1);
        
        for (int num : nums) {
            int index = (int) ((num - min) / size);
            buckets[index].isUsed = true;
            buckets[index].start = Math.min(buckets[index].start, num);
            buckets[index].end = Math.max(buckets[index].end, num);
        }
        
        int result = 0;
        int pre = min;

        for (Bucket bucket : buckets) {
            if (bucket.isUsed) {
                result = Math.max(result, bucket.start - pre);
                pre = bucket.end;
            }
        }
        
        return result;
    }
}
