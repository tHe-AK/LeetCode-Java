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
