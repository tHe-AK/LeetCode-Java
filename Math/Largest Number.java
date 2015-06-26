public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        int len = nums.length;
        String[] rec = new String[len];
        
        for (int i = 0; i < nums.length; i++) {
            rec[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(rec, new Comparator<String>() {
            public int compare(String a, String b) {
                return -(a + b).compareTo(b + a);
            }
        });
        
        for (String str : rec) {
            sb.append(str);
        }
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
