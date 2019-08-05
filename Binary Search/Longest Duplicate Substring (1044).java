class Solution {
    public String longestDupSubstring(String S) {
        int MOD = 1_000_000_007;
        int low = 1;
        int high = S.length() - 1;
        int start = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int idx = getIdx(S, mid, MOD);
                
            if (idx >= 0) {
                start = idx;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return high > 0 ? S.substring(start, start + high) : "";
    }
    
    private int getIdx(String S, int N, int MOD) {
        Map<Long, Set<Integer>> map = new HashMap<>();
        long num = 0;
        long pow = 1;
        
        for (int i = 0; i < S.length(); i++) {
            num = (num * 26 % MOD + S.charAt(i) - 'a') % MOD;
            
            if (i < N - 1) {
                pow = (pow * 26) % MOD;
            } else {
                int j = i - N + 1;
                
                if (map.containsKey(num)) {
                    for (int idx : map.get(num)) {
                        if (S.substring(idx, idx + N).equals(S.substring(j, j + N))) {
                            return j;
                        }
                    }
                }

                map.putIfAbsent(num, new HashSet<>());
                map.get(num).add(j);
                num = (num - ((S.charAt(j) - 'a') * pow % MOD) + MOD) % MOD;
            }
        }
        
        return -1;
    }
}
