class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int low = 1;
        int high = n;
        
        for (int i = 0; i < n; i++) {
            if (i < k) {
                res[i] = i % 2 == 0 ? low++ : high--;
            } else {
                res[i] = k % 2 == 0 ? high-- : low++;
            }
        }
        
        return res;
    }
}
