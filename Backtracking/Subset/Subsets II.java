public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        int size = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int start = (i > 0 && nums[i] == nums[i - 1]) ? size : 0;
            size = result.size();
            
            for (int j = start; j < size; j++) {
            	List<Integer> next = new ArrayList(result.get(j));
                next.add(nums[i]);
                result.add(next);
            }
        }
        
        return result;
    }
}

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(curr));
        
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                curr.add(nums[i]);
                dfs(nums, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
