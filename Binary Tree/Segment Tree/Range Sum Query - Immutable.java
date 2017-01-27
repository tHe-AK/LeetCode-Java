public class NumArray {
    private int[] nums;
    
    public NumArray(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        this.nums = nums;
        
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length || i > j) {
            throw new IllegalArgumentException();
        }
        
        if (i == 0) {
            return nums[j];
        } else {
            return nums[j] - nums[i - 1];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
