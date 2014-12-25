public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            throw new IllegalArgumentException();
        }

        int[] candidate = new int[2];
        int[] count = new int[2];
        
        for (int i = 0; i < nums.size(); i++) {
            if (count[0] == 0) {
                candidate[0] = nums.get(i);
                count[0] = 1;
            }
            else if (candidate[0] == nums.get(i)) {
                count[0]++;
            }
            else if (count[1] == 0) {
                candidate[1] = nums.get(i);
                count[1] = 1;
            }
            else if (candidate[1] == nums.get(i)) {
                count[1]++;
            }
            else {
                count[0]--;
                count[1]--;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (count[i] > 0) {
                count[i] = 0;
                
                for (int j = 0; j < nums.size(); j++) {
                    if (nums.get(j) == candidate[i]) {
                        count[i]++;
                    }
                }
                
                if (count[i] > nums.size() / 3) {
                    return candidate[i];
                }
            }
        }

        throw new RuntimeException("Input is not valid.");    }
}