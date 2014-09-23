public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        int max = 0;
        HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < num.length; i++) {
            if (rec.containsKey(num[i])) {
                continue;
            }
            
            int left = rec.containsKey(num[i] - 1) ? rec.get(num[i] - 1) : 0;
            int right = rec.containsKey(num[i] + 1) ? rec.get(num[i] + 1) : 0;
            int len = left + right + 1;
            max = Math.max(max, len);
            
            rec.put(num[i], len);
            rec.put(num[i] - left, len);
            rec.put(num[i] + right, len);
        }
        
        return max;
    }
}