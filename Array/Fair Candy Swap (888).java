class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int sum1 = 0;
        int sum2 = 0;
        
        for (int i : A) {
            sum1 += i;
            set.add(i);
        }
        
        for (int i : B) {
            sum2 += i;
        }
        
        int diff = (sum1 - sum2) / 2;
        
        for (int i : B) {
            if (set.contains(i + diff)) {
                return new int[] { i + diff, i };
            }
        }
        
        return null;
    }
}
