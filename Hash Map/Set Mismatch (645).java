public class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dup = 0;
        long sum = (1 + nums.length) * nums.length / 2;
        
        for (int num : nums) {
            if (!set.add(num)) {
                dup = num;
            } else {
                sum -= num;
            }
        }
        
        return new int[] { dup, (int) sum };
    }
}
