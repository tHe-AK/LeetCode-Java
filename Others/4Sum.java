public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (num == null || num.length < 4) {
            return result;
        }
        
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                
                int diff = target - num[i] - num[j];
                int left = j + 1;
                int right = num.length - 1;
                
                while (left < right) {
                    int sum = num[left] + num[right];
                    
                    if (sum == diff) {
                        List<Integer> cur = new ArrayList<Integer>();
                        cur.add(num[i]);
                        cur.add(num[j]);
                        cur.add(num[left]);
                        cur.add(num[right]);
                        result.add(cur);
                        
                        left++;
                        right--;
                        
                        while (left < right && num[left] == num[left - 1]) {
                            left++;
                        }
                        
                        while (left < right && num[right] == num[right + 1]) {
                            right--;
                        }
                    }
                    else if (sum < diff) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}
