public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() > 1) {
            result.add(new ArrayList<>(curr));
        }
        
        Set<Integer> visited = new HashSet<>();
        
        for (int i = start; i < nums.length; i++) {
            if (!visited.contains(nums[i]) && (curr.size() == 0 || curr.get(curr.size() - 1) <= nums[i])) {
                visited.add(nums[i]);
                curr.add(nums[i]);
                dfs(nums, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
