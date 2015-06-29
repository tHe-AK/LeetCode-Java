class Bucket {
    int start;
    int end;
    
    public Bucket() {
        start = -1;
        end = -1;
    }
}

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int len = nums.length;
        Bucket[] rec = new Bucket[len + 1];
        int min = nums[0];
        int max = nums[0];
        
        for (int i = 0; i <= len; i++) {
            rec[i] = new Bucket();
        }
        
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        double val = 1.0 * len / (max - min);
        
        for (int i = 0; i < len; i++) {
            int index = (int) ((nums[i] - min) * val);
            
            if (rec[index].start == -1) {
                rec[index].start = nums[i];
                rec[index].end = nums[i];
            }
            else {
                rec[index].start = Math.min(rec[index].start, nums[i]);
                rec[index].end = Math.max(rec[index].end, nums[i]);
            }
        }
        
        int result = 0;
        int pre = rec[0].end;
        
        for (int i = 1; i <= len; i++) {
            if (rec[i].start != -1) {
                result = Math.max(result, rec[i].start - pre);
                pre = rec[i].end;
            }
        }
        
        return result;
    }
}
