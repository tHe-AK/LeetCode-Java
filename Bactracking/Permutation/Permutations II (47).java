public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] nums, boolean[] rec, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!rec[i] && (i == 0 || nums[i] != nums[i - 1] || rec[i - 1])) {
                rec[i] = true;
                curr.add(nums[i]);
                helper(nums, rec, curr, result);
                rec[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}
