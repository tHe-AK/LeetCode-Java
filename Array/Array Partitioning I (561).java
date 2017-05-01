public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        
        return sum;
    }
}

public class Solution {
    public int arrayPairSum(int[] nums) {
        int N = 10000;
        int[] rec = new int[N * 2 + 1];
        int sum = 0;
        boolean flag = true;
        
        for (int num : nums) {
            rec[num + N]++;
        }
        
        for (int i = 0; i < rec.length; i++) {
            if (rec[i] > 0) {
                sum += (i - N) * (rec[i] / 2);
                
                if (rec[i] % 2 == 1) {
                    sum += flag ? i - N : 0;
                    flag = !flag;
                }
            }
        }
        
        return sum;
    }
}
