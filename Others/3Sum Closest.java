public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (num == null || num.length < 3) {
            return result;
        }
        
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            int target = -num[i];
            int left = i + 1;
            int right = num.length - 1;
            
            while (left < right) {
                int sum = num[left] + num[right];
                if (sum == target) {
                    List<Integer> tuple = new ArrayList<Integer>();
                    tuple.add(num[i]);
                    tuple.add(num[left]);
                    tuple.add(num[right]);
                    result.add(tuple);
                    
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
        
        return result;
    }
}
