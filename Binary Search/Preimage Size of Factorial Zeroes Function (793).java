class Solution {
    public int preimageSizeFZF(int K) {
        return (int) (binarySearch(K) - binarySearch(K - 1));
    }

    private long binarySearch(int K) {
        long low = 0;
        long high = 5L * (K + 1);

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (numOfTrailingZeros(mid) <= K) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private long numOfTrailingZeros(long num) {
        long count = 0;

        while (num > 0) {
            count += num / 5;
            num /= 5;
        }

        return count;
    }
}
