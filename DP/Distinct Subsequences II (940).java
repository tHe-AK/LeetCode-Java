class Solution {
    public int distinctSubseqII(String S) {
        int MOD = 1_000_000_007;
        int[] count = new int[26];
        int res = 0;
        
        for (char ch : S.toCharArray()) {
            int idx = ch - 'a';
            int added = (res + 1 - count[idx] + MOD) % MOD;
            count[idx] = (res + 1) % MOD;
            res = (res + added) % MOD;
        }
        
        return res;
    }
}
