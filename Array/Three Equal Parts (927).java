class Solution {
    public int[] threeEqualParts(int[] A) {
        int N = A.length;
        int one = 0;
        
        for (int i : A) {
            if (i == 1) {
                one++;
            }
        }
        
        if (one == 0) {
            return new int[] { 0, N - 1 };
        }
        
        if (one % 3 != 0) {
            return new int[] { -1, -1 };
        }
        
        int count = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        
        for (int i = 0; i < N; i++) {
            if (A[i] == 1) {                
                if (count == 0) {
                    x = i;
                } else if (count == one / 3) {
                    y = i;
                } else if (count == one / 3 * 2) {
                    z = i;
                }
                
                count++;
            }
        }
        
        while (z < N) {
            if (A[x] == A[y] && A[y] == A[z]) {
                x++;
                y++;
                z++;
            } else {
                return new int[] { -1, -1 };
            }
        }
        
        return new int[] { x - 1, y };
    }
}
