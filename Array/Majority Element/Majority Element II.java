public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] candidate = new int[2];
        int[] count = new int[2];
        
        for (int num : nums) {
            if (num == candidate[0]) {
                count[0]++;
            } else if (num == candidate[1]) {
                count[1]++;
            } else if (count[0] == 0) {
                candidate[0] = num;
                count[0] = 1;
            } else if (count[1] == 0) {
                candidate[1] = num;
                count[1] = 1;
            } else {
                count[0]--;
                count[1]--;
            }
        }
        
        count[0] = count[1] = 0;
        
        for (int num : nums) {
            if (num == candidate[0]) {
                count[0]++;
            } else if (num == candidate[1]) {
                count[1]++;
            }
        }
        
        if (count[0] > nums.length / 3) {
            result.add(candidate[0]);
        }
        
        if (count[1] > nums.length / 3) {
            result.add(candidate[1]);
        }
        
        return result;
    }
}
