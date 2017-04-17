public class Solution {
    public String optimalDivision(int[] nums) {
        int len = nums.length;
        
        if (len == 1) {
            return nums[0] + "";
        } else if (len == 2) {
            return nums[0] + "/" + nums[1];
        } else {
            StringBuilder res = new StringBuilder(nums[0] + "/(" + nums[1]);
            
            for (int i = 2; i < len; i++) {
                res.append("/" + nums[i]);
            }
            
            res.append(")");
            return res.toString();
        }
    }
}
