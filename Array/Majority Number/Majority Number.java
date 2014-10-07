public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            throw new IllegalArgumentException();
        }
        
        int candidate = 0;
        int count = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            }
            else if (candidate == nums.get(i)) {
                count++;
            }
            else {
                count--;
            }
        }
        
        if (count != 0) {
            count = 0;
            
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == candidate) {
                    count++;
                }
            }
            
            if (count > nums.size() / 2) {
                return candidate;
            }
        }
        
        throw new RuntimeException("Input is not valid.");
    }
}

