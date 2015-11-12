public class NumArray {
    private int[] sum;
    
    public NumArray(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        int len = nums.length;
        sum = new int[len + 1];
        
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || i >= sum.length - 1 || j < 0 || j >= sum.length - 1 || i > j) {
            throw new IllegalArgumentException();
        }
        
        return sum[j + 1] - sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
