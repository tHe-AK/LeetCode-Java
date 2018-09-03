class Solution {
    public int[] pourWater(int[] H, int V, int K) {
        while (V-- > 0) {
            boolean canFall = false;

            for (int i = -1; i <= 1; i += 2) {
                int j = K;
                int idx = K;

                while (j > 0 && j < H.length - 1 && H[j + i] <= H[j]) {
                    if (H[j + i] < H[j]) {
                        idx = j + i;
                    }

                    j += i;
                }

                if (idx != K) {
                    H[idx]++;
                    canFall = true;
                    break;
                }
            }

            if (!canFall) {
                H[K]++;
            }
        }

        return H;
    }
}
