public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }

        int[] candidate = new int[2];
        int[] count = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            if (count[0] == 0) {
                candidate[0] = nums[i];
                count[0] = 1;
            }
            else if (candidate[0] == nums[i]) {
                count[0]++;
            }
            else if (count[1] == 0) {
                candidate[1] = nums[i];
                count[1] = 1;
            }
            else if (candidate[1] == nums[i]) {
                count[1]++;
            }
            else {
                count[0]--;
                count[1]--;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (count[i] > 0 && !result.contains(candidate[i])) {
                count[i] = 0;
                
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == candidate[i]) {
                        count[i]++;
                    }
                }
                
                if (count[i] > nums.length / 3) {
                    result.add(candidate[i]);
                }
            }
        }

        return result;
    }
}
