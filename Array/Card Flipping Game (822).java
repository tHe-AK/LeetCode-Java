class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        
        for (int num : fronts) {
            if (!set.contains(num)) {
                res = res == 0 ? num : Math.min(res, num);
            }
        }
        
        for (int num : backs) {
            if (!set.contains(num)) {
                res = res == 0 ? num : Math.min(res, num);
            }
        }
        
        return res;
    }
}
