public class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int curr = 0;
        
        while (curr <= high) {
            if (nums[curr] == 0) {
                swap(low++, curr++);
            } else if (nums[curr] == 2) {
                swap(curr, high--);
            } else {
                curr++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
