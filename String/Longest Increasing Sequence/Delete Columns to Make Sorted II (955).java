class Solution {
    public int minDeletionSize(String[] A) {
        int N = A.length;
        boolean[] sorted = new boolean[N - 1];
        int ans = 0;

        for (int i = 0; i < A[0].length(); i++) {
            int j = 0;
            
            while (j < N - 1) {
                if (!sorted[j] && A[j].charAt(i) > A[j + 1].charAt(i)) {
                    ans++;
                    break;
                }
                
                j++;
            }
            
            if (j == N - 1) {
                j = 0;
                
                while (j < N - 1) {
                    if (A[j].charAt(i) < A[j + 1].charAt(i)) {
                        sorted[j] = true;
                    }
                    
                    j++;
                }
            }
        }
        
        return ans;
    }
}
