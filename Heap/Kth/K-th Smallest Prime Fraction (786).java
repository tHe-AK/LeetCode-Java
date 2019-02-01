class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int N = A.length;
        Queue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> Double.compare(1.0 * A[a[0]] / A[a[1]], 1.0 * A[b[0]] / A[b[1]]));
        pq.offer(new int[] { 0, N - 1 });

        while (K-- > 1) {
            int[] peek = pq.poll();
            int i = peek[0];
            int j = peek[1];

            if (i + 1 < j) {
                if (j == N - 1) {
                    pq.offer(new int[] { i + 1, N - 1 });
                }
                
                pq.offer(new int[] { i, j - 1 });
            }
        }
        
        int[] peek = pq.peek();
        return new int[] { A[peek[0]], A[peek[1]] };
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int N = A.length;
        double low = 1.0 * A[0] / A[N - 1];
        double high = 1;

        while (low <= high) {
            double mid = low + (high - low) / 2;
            int count = 0;
            int p = A[0];
            int q = A[N - 1];

            for (int i = 0; i < N - 1; i++) {
                for (int j = N - 1; j >= i; j--) {
                    if (A[i] > mid * A[j]) {
                        count += N - j - 1;

                        if (j + 1 < N && A[i] * q > p * A[j + 1]) {
                            p = A[i];
                            q = A[j + 1];
                        }

                        break;
                    }
                }
            }

            if (count < K) {
                low = mid;
            } else if (count > K) {
                high = mid;
            } else {
                return new int[] { p, q };
            }
        }

        return null;
    }
}
