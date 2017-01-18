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
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        helper(num, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] num, int start, List<Integer> cur, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(cur));
        
        for (int i = start; i < num.length; i++) {
            if (i != start && num[i] == num[i - 1]) {
                continue;
            }
            
            cur.add(num[i]);
            helper(num, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
