class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int len = stations.length;
        double low = 0;
        double high = stations[len - 1] - stations[0];

        while (low + 1e-6 < high) {
            double mid = (high - low) / 2 + low;
            int count = 0;

            for (int i = 0; i < len - 1; i++) {
                count += (int) Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }

            if (count <= K) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }
}
