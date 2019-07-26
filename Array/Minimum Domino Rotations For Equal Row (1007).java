class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int N = A.length;
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < N; i++) {
            if (A[i] != A[0] && B[i] != A[0]) {
                break;
            }
            
            if (A[i] != A[0]) {
                count1++;
            }
            
            if (B[i] != A[0]) {
                count2++;
            }

            if (i == N - 1) {
                return Math.min(count1, count2);
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int i = 0; i < N; i++) {
            if (A[i] != B[0] && B[i] != B[0]) {
                break;
            }
            
            if (A[i] != B[0]) {
                count1++;
            }
            
            if (B[i] != B[0]) {
                count2++;
            }

            if (i == N - 1) {
                return Math.min(count1, count2);
            }
        }

        return -1;
    }
}

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int N = 6;
        int[] count1 = new int[N + 1];
        int[] count2 = new int[N + 1];
        int[] same = new int[N + 1];
        
        for (int i = 0; i < A.length; i++) {
            count1[A[i]]++;
            count2[B[i]]++;
            
            if (A[i] == B[i]) {
                same[A[i]]++;
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (count1[i] + count2[i] - same[i] == A.length) {
                return Math.min(count1[i], count2[i]) - same[i];
            }
        }

        return -1;
    }
}
