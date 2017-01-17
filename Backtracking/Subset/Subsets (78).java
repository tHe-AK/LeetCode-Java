public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int count = 1 << len;
        
        for (int i = 0; i < count; i++) {
            List<Integer> curr = new ArrayList<>();
            
            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) {
                    curr.add(nums[j]);
                }
            }
            
            result.add(curr);
        }
        
        return result;
    }
}

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            
            for (int j = 0; j < size; j++) {
            	List<Integer> next = new ArrayList(result.get(j));
                next.add(nums[i]);
                result.add(next);
            }
        }
        
        return result;
    }
}

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(nums, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(curr));
        
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(nums, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
