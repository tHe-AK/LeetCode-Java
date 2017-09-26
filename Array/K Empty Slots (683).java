class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        int[] rec = new int[n];
        
        for (int i = 0; i < n; i++) {
            rec[flowers[i] - 1] = i + 1;
        }
        
        int start = 0;
        int end = k + 1;
        int min = Integer.MAX_VALUE; 
        
        while (end < n) {
            int max = Math.max(rec[start], rec[end]);
            int i = start + 1;
            
            while (i < end && rec[i] > max) {
                i++;
            }
            
            if (i == end) {
                min = Math.min(min, max);
            }
            
            start = i;
            end = start + k + 1;
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < flowers.length; i++) {
            int pos = flowers[i];
            Integer low = set.lower(pos);
            Integer high = set.higher(pos);
            
            if ((low != null && low == pos - k - 1) || (high != null && high == pos + k + 1)) {
                return i + 1;
            }
            
            set.add(pos);
        }
        
        return -1;
    }
}
