public class Solution {
    public List<List<Integer>> kSum(int[] num, int target, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (num == null || num.length < k) {
            return result;
        }
        
        Arrays.sort(num);
        
        helper(num, target, k, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] num, int target, int k, int start, List<Integer> cur, List<List<Integer>> result) {
        if (k > 2) {
            for (int i = start; i < num.length - k + 1; i++) {
                if (i != start && num[i] == num[i - 1]) {
                    continue;
                }
                
                cur.add(num[i]);
                helper(num, target - num[i], k - 1, i + 1, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
        else {
            int left = start;
            int right = num.length - 1;
                
            while (left < right) {
                int sum = num[left] + num[right];
                    
                if (sum == target) {
                    List<Integer> temp = new ArrayList<Integer>(cur);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    result.add(temp);
                        
                    left++;
                    right--;
                        
                    while (left < right && num[left] == num[left - 1]) {
                        left++;
                    }
                        
                    while (left < right && num[right] == num[right + 1]) {
                        right--;
                    }
                }
                else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
    }
}
