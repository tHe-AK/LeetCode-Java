public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                
                int low = j + 1;
                int high = num.length - 1;
                
                while (low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];
                    
                    if (sum == target) {
                        List<Integer> cur = new ArrayList<Integer>();
                        cur.add(num[i]);
                        cur.add(num[j]);
                        cur.add(num[low]);
                        cur.add(num[high]);
                        result.add(cur);
                        
                        low++;
                        high--;
                        
                        while (low < high && num[low] == num[low - 1]) {
                            low++;
                        }
                        
                        while (low < high && num[high] == num[high + 1]) {
                            high--;
                        }
                    }
                    else if (sum < target) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        
        return result;
    }
}