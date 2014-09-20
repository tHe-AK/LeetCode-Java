public class Solution {
    public int kSumNum(int[] num, int target, int k) {
        int[] result = new int[1];
        
        if (num == null || num.length < k) {
            return result[0];
        }
        
        Arrays.sort(num);
        
        helper(num, target, k, 0, result);
        
        return result[0];
    }
    
    private void helper(int[] num, int target, int k, int start, int[] result) {
        if (k > 2) {
            for (int i = start; i < num.length - k + 1; i++) {
                if (i != start && num[i] == num[i - 1]) {
                    continue;
                }
                
                helper(num, target - num[i], k - 1, i + 1, result);
            }
        }
        else {
            int left = start;
            int right = num.length - 1;
                
            while (left < right) {
                int sum = num[left] + num[right];
                    
                if (sum == target) {
                    result[0]++;
                        
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
