class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int N = A.length;
        int half = N / 2;
        int total = 0;
        
        for (int num : A) {
            total += num;
        }
        
        Set<Integer>[] sums = new Set[half + 1];
        
        for (int i = 0; i < sums.length; i++) {
            sums[i] = new HashSet<>();
        }
        
        sums[0].add(0);
        
        for (int num : A) {
            for (int i = half; i > 0; i--) {
                for (Integer val : sums[i - 1]) {
                    int sum = val + num;

                    if (sum * (N - i) == (total - sum) * i) {
                        return true;
                    }
                    
                    sums[i].add(sum);
                }
            }
        }
        
        return false;
    }
}
