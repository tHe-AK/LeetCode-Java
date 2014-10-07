public class Solution {
    public int partitionArray(ArrayList<Integer> nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        int cur = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < k) {
                int temp = nums.get(i);
                nums.set(i, nums.get(cur));
                nums.set(cur, temp);
                cur++;
            }
        }
        
        return cur;
    }
}

public class Solution {
    public int partitionArray(ArrayList<Integer> nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        int low = 0;
        int high = nums.size() - 1;
        
        while (low <= high) {
            if (nums.get(low) < k) {
                low++;
            }
            else if (nums.get(high) >= k) {
                high--;
            }
            else {
                int temp = nums.get(low);
                nums.set(low, nums.get(high));
                nums.set(high, temp);
                low++;
                high--;
            }
        }
        
        return low;
    }
}