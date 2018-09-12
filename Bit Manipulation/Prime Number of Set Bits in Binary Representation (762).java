class Solution {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        
        for (int x = L; x <= R; ++x) {
            int count = Integer.bitCount(x);
            
            if (count == 2 || count == 3 || count == 5 || count == 7 || count == 11 || count == 13 || count == 17 || count == 19) {
                ans++;
            }
        }
        
        return ans;
    }
}
