public class Solution {
    public String originalDigits(String s) {
        int[] count = new int[128];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        
        int[] nums = new int[10];
        nums[0] = count['z'];
        nums[2] = count['w'];
        nums[4] = count['u'];
        nums[6] = count['x'];
        nums[8] = count['g'];
        nums[1] = count['o'] - nums[0] - nums[2] - nums[4];
        nums[3] = count['h'] - nums[8];
        nums[5] = count['f'] - nums[4];
        nums[7] = count['s'] - nums[6];
        nums[9] = count['i'] - nums[5] - nums[6] - nums[8];
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}
