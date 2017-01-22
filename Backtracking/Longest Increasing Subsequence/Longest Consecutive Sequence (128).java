public class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int num : nums) {
            if (set.remove(num)) {
                int val = num;
                int count = 1;
                
                while (set.remove(val - 1)) {
                    count++;
                    val--;
                }
                
                val = num;
                
                while (set.remove(num + 1)) {
                    count++;
                    num++;
                }
                
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
}

public class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> rec = new HashMap<>();
        
        for (int num : nums) {
            if (rec.containsKey(num)) {
                continue;
            }
            
            int left = rec.containsKey(num - 1) ? rec.get(num - 1) : 0;
            int right = rec.containsKey(num + 1) ? rec.get(num + 1) : 0;
            int len = left + right + 1;
            max = Math.max(max, len);
            
            rec.put(num, len);
            rec.put(num - left, len);
            rec.put(num + right, len);
        }
        
        return max;
    }
}
