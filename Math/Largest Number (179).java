public class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int len = nums.length;
        String[] rec = new String[len];
        
        for (int i = 0; i < nums.length; i++) {
            rec[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(rec, (a, b) -> (b + a).compareTo(a + b));
        
        for (String str : rec) {
            sb.append(str);
        }
        
        if (sb.length() > 0 && sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}
