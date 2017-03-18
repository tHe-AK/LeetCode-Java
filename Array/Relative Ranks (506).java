public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        Integer[] index = new Integer[len];
        String[] result = new String[len];

        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, (a, b) -> Integer.compare(nums[b], nums[a]));

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            } else if (i == 1) {
                result[index[i]] = "Silver Medal";
            } else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            } else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }
}
