public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        
        int max = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if (hashMap.containsKey(num[i]) == false) {
                int len = 1;
                int pre = num[i] - 1;
                int next = num[i] + 1;
                
                if (hashMap.containsKey(pre) == true) {
                    len += hashMap.get(pre);
                }
                if (hashMap.containsKey(next) == true) {
                    len += hashMap.get(next);
                }
                
                hashMap.put(num[i], len);
                if (len > max) {
                    max = len;
                }
                
                if (hashMap.containsKey(pre) == true) {
                    hashMap.put(pre - hashMap.get(pre) + 1, len);
                }
                if (hashMap.containsKey(next) == true) {
                    hashMap.put(next + hashMap.get(next) - 1, len);
                }
            }
        }
        
        return max;
    }
}
