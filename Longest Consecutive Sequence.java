public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        int max = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < num.length; i++) {
            if (hashMap.containsKey(num[i])) {
                continue;
            }
            
            int len1 = hashMap.containsKey(num[i] - 1) ? hashMap.get(num[i] - 1) : 0;
            int len2 = hashMap.containsKey(num[i] + 1) ? hashMap.get(num[i] + 1) : 0;
            int len = len1 + len2 + 1;
            
            hashMap.put(num[i], len);
            hashMap.put(num[i] - len1, len);
            hashMap.put(num[i] + len2, len);
            
            max = Math.max(max, len);
        }
        
        return max;
    }
}
